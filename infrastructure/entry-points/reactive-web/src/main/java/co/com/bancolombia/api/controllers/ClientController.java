package co.com.bancolombia.api.controllers;

import co.com.bancolombia.api.dto.mappers.DTOtoModelMapper;
import co.com.bancolombia.api.dto.requests.ClientDTO;
import co.com.bancolombia.usecase.client.ClientUseCase;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/client", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ClientController {

    private final ClientUseCase clientUseCase;
    private final DTOtoModelMapper mapper;

    @PostMapping
    public ResponseEntity<?> save(
            @Valid @RequestBody ClientDTO clientDTO){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(clientUseCase.saveClient(mapper.toModel(clientDTO)));
    }

    @GetMapping
    public ResponseEntity<?> hola(){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("hola xdd");
    }

}
