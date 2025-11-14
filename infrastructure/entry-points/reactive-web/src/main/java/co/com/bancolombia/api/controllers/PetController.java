package co.com.bancolombia.api.controllers;

import co.com.bancolombia.api.controllers.utils.Utility;
import co.com.bancolombia.api.dto.mappers.RequestMapper;
import co.com.bancolombia.api.dto.mappers.ResponseMapper;
import co.com.bancolombia.api.dto.requests.PetDTO;
import co.com.bancolombia.api.dto.response.models.pets.CreatePetRSDTO;
import co.com.bancolombia.api.dto.response.models.pets.PetRSDTO;
import co.com.bancolombia.usecase.pet.PetUseCase;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/pet", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class PetController {
    private final PetUseCase petUseCase;
    private final RequestMapper requestMapper;
    private final ResponseMapper responseMapper;

    @PostMapping
    public ResponseEntity<?> save(
            @Valid @RequestBody PetDTO petDTO) {
        CreatePetRSDTO createPetRSDTO = responseMapper.toResponseFull(
                petUseCase.savePet(requestMapper.toModel(petDTO), petDTO.getIdClient()));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Utility.structureRS(createPetRSDTO, HttpStatus.CREATED.value()));
    }

    @PutMapping
    public ResponseEntity<?> update(
            @Valid @RequestBody PetDTO petDTO) {
        CreatePetRSDTO createPetRSDTO = responseMapper.toResponseFull(
                petUseCase.updatedPet(requestMapper.toModel(petDTO), petDTO.getIdClient()));
        return ResponseEntity.status(HttpStatus.OK)
                .body(Utility.structureRS(createPetRSDTO, HttpStatus.CREATED.value()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        PetRSDTO petRSDTO = responseMapper.toResponse(petUseCase.getById(id));
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(Utility.structureRS(petRSDTO, HttpStatus.CREATED.value()));
    }

    @GetMapping("/all")
    public ResponseEntity<?>  getAll() {
        List<PetRSDTO> pets = responseMapper.toRSListPets(petUseCase.getAllPets());
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(Utility.structureRS(pets, HttpStatus.CREATED.value()));
    }
}
