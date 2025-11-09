package co.com.bancolombia.api.controllers;

import co.com.bancolombia.api.dto.mappers.RequestMapper;
import co.com.bancolombia.api.dto.mappers.ResponseMapper;
import co.com.bancolombia.api.dto.requests.ClientDTO;
import co.com.bancolombia.api.dto.response.CreateClientRSDTO;
import co.com.bancolombia.model.client.Client;
import co.com.bancolombia.usecase.client.ClientUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.CREATED;

@ExtendWith(MockitoExtension.class)
class ClientControllerTest {

    @Mock
    private ClientUseCase clientUseCase;

    @Mock
    private RequestMapper requestMapper;

    @Mock
    private ResponseMapper responseMapper;

    @InjectMocks
    private ClientController clientController;

    @Test
    void givenValidClientDTO_whenSave_thenReturnsCreatedClient() {
        // Arrange
        ClientDTO clientDTO = ClientDTO.builder()
                .email("jjf@email.com")
                .phone("32132")
                .lastName("duque")
                .name("juan")
                .address("cfddfsd")
                .build();

        Client clientSaved = Client.builder()
                .id(1L)
                .lastName("duque")
                .email("jjf@email.com")
                .phone("32132")
                .name("juan")
                .address("cfddfsd")
                .createdDate(getDate())
                .build();

        CreateClientRSDTO response = new CreateClientRSDTO(
                1L, "juan", "duque", "32132", "jjf@email.com", "cfddfsd", getDate()
        );

        when(requestMapper.toModel(any(ClientDTO.class))).thenReturn(clientSaved);
        when(clientUseCase.saveClient(any(Client.class))).thenReturn(clientSaved);
        when(responseMapper.toResponseFull(any(Client.class))).thenReturn(response);

        ResponseEntity<?> result = clientController.save(clientDTO);

        assertThat(result.getStatusCode()).isEqualTo(CREATED);
        assertThat(result.getBody()).isInstanceOf(CreateClientRSDTO.class);
        CreateClientRSDTO body = (CreateClientRSDTO) result.getBody();
        Assertions.assertNotNull(body);
        assertThat(body.name()).isEqualTo("juan");
    }

    private static LocalDateTime getDate() {
        return LocalDateTime.parse("2025-02-01T00:00:00");
    }
}
