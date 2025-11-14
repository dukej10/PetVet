package co.com.bancolombia.api.controllers;

import co.com.bancolombia.api.controllers.utils.Utility;
import co.com.bancolombia.api.dto.mappers.RequestMapper;
import co.com.bancolombia.api.dto.mappers.ResponseMapper;
import co.com.bancolombia.api.dto.requests.ClientDTO;
import co.com.bancolombia.api.dto.response.models.client.ClientRSDTO;
import co.com.bancolombia.api.dto.response.models.client.CreateClientRSDTO;
import co.com.bancolombia.usecase.client.ClientUseCase;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/client", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ClientController {

    private final ClientUseCase clientUseCase;
    private final RequestMapper requestMapper;
    private final ResponseMapper responseMapper;

    @PostMapping
    public ResponseEntity<?> save(
            @Valid @RequestBody ClientDTO clientDTO){
        CreateClientRSDTO clientDTOR = responseMapper.toResponseFull(clientUseCase
                .saveClient(requestMapper.toModel(clientDTO)));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Utility.structureRS(clientDTOR, HttpStatus.CREATED.value()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        ClientRSDTO clientDTOR = responseMapper.toResponse(clientUseCase.getById(id));
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(Utility.structureRS(clientDTOR, HttpStatus.FOUND.value()));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getByAll() {
        List<ClientRSDTO> clientsDTOR = responseMapper.toRSList(clientUseCase.getAllClients());
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(Utility.structureRS(clientsDTOR, HttpStatus.FOUND.value()));
    }

}
