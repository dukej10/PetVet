package co.com.bancolombia.api.controllers;

import co.com.bancolombia.api.controllers.utils.Utility;
import co.com.bancolombia.api.dto.mappers.RequestMapper;
import co.com.bancolombia.api.dto.mappers.ResponseMapper;
import co.com.bancolombia.api.dto.requests.AppointmentDTO;
import co.com.bancolombia.usecase.appointment.AppointmentUseCase;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/appointment", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class AppointmentController {

    private final AppointmentUseCase appointmentUseCase;
    private final RequestMapper requestMapper;
    private final ResponseMapper responseMapper;

    @PostMapping
    public ResponseEntity<?> save(
            @Valid @RequestBody AppointmentDTO appointmentDTO){
        var appointment = appointmentUseCase.save(requestMapper.toModel(appointmentDTO), appointmentDTO.getIdPet());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Utility.structureRS(responseMapper.toResponseFull(appointment), HttpStatus.CREATED.value()));
    }



}
