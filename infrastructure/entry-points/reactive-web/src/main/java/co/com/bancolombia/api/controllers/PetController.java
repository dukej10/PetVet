package co.com.bancolombia.api.controllers;

import co.com.bancolombia.api.dto.mappers.RequestMapper;
import co.com.bancolombia.api.dto.mappers.ResponseMapper;
import co.com.bancolombia.api.dto.requests.PetDTO;
import co.com.bancolombia.api.dto.response.CreatePetRSDTO;
import co.com.bancolombia.api.dto.response.PetRSDTO;
import co.com.bancolombia.usecase.pet.PetUseCase;
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
@RequestMapping(value = "/api/pet", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class PetController {
    private final PetUseCase petUseCase;
    private final RequestMapper requestMapper;
    private final ResponseMapper responseMapper;

    @PostMapping
    public ResponseEntity<?> save(
            @Valid @RequestBody PetDTO petDTO){
        CreatePetRSDTO createPetRSDTO = responseMapper.toResponseFull(petUseCase.savePet(requestMapper.toModel(petDTO), petDTO.getIdClient()));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        createPetRSDTO
                );
    }
}
