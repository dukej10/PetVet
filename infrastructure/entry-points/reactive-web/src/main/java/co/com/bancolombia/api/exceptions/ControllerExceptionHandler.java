package co.com.bancolombia.api.exceptions;

import co.com.bancolombia.api.controllers.utils.Utility;
import co.com.bancolombia.api.dto.response.ResponseDTO;
import co.com.bancolombia.model.exceptions.GeneralException;
import co.com.bancolombia.model.exceptions.NoDataFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import java.util.Date;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    // 1️⃣ Manejo de validaciones de DTOs @Valid
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatusCode status,  // ✅ CAMBIAR A HttpStatusCode
            WebRequest request) {

        List<ErrorResponse.FieldError> fieldErrors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> new ErrorResponse.FieldError(error.getField(), error.getDefaultMessage()))
                .collect(Collectors.toList());

        ErrorResponse errorResponse = new ErrorResponse(
                new Date(),
                "Validation failed",
                request.getDescription(false),
                fieldErrors
        );

        return new ResponseEntity<>(
                Utility.structureRS(errorResponse,HttpStatus.BAD_REQUEST.value()),
                HttpStatus.BAD_REQUEST);
    }

    // 🧩 Maneja errores de validación en parámetros o servicios
    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<Object> handleValidationError(ConstraintViolationException exception) {
        List<Map<String, String>> errors = exception.getConstraintViolations()
                .stream()
                .map(violation -> Map.of(
                        "field", violation.getPropertyPath().toString()
                                .substring(violation.getPropertyPath().toString().lastIndexOf('.') + 1),
                        "error", violation.getMessage()))
                .toList();

        return ResponseEntity.badRequest().body(
                Utility.structureRS(Map.of("errors", errors), HttpStatus.BAD_REQUEST.value())
        );
    }

    // 3️⃣ Manejo de excepciones personalizadas
    @ExceptionHandler({NoDataFoundException.class, GeneralException.class})
    public ResponseEntity<ResponseDTO<ErrorResponse>> handleCustomException(
            RuntimeException ex, WebRequest request) {

        ErrorResponse errorResponse = new ErrorResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(false),
                null
        );

        return new ResponseEntity<>(
                Utility.structureRS(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR.value()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // 4️⃣ Manejo de cualquier otra excepción global
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDTO<ErrorResponse>> handleGlobalException(Exception ex, WebRequest request) {

        ErrorResponse errorResponse = new ErrorResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(false),
                null
        );

        return new ResponseEntity<>(
                Utility.structureRS(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR.value()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}