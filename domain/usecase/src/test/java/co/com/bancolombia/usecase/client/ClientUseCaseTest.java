package co.com.bancolombia.usecase.client;

import co.com.bancolombia.model.client.Client;
import co.com.bancolombia.model.client.gateways.ClientRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ClientUseCaseTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientUseCase clientUseCase;

    @Test
    void shouldSaveClient() {
        Client clientToSave = Client.builder()
                .id(1L)
                .email("")
                .phone("")
                .name("")
                .address("")
                .createdDate(getDate()).build();

        Client clientSaved = Client.builder()
                .id(1L)
                .email("")
                .phone("")
                .name("")
                .address("")
                .createdDate(getDate()).build();
        when(clientRepository.saveClient(clientToSave))
                .thenReturn(clientSaved);

        Client client = clientUseCase.saveClient(clientToSave);

        assertEquals(1, client.getId());
    }

    private static LocalDateTime getDate() {
        return LocalDateTime.parse("2025-02-01T00:00:00");
    }

    @Test
    void shoudlUpdatedClientOK () {
        Client clientToUpdated = Client.builder()
                .id(1L)
                .email("")
                .phone("")
                .name("")
                .lastName("")
                .address("")
                .createdDate(getDate()).build();

        Client clientUpdated = Client.builder()
                .id(1L)
                .email("")
                .phone("")
                .name("")
                .lastName("")
                .address("")
                .createdDate(getDate())
                .updatedDate(getDate())
                .build();
        when(clientRepository.findById(clientToUpdated.getId())).thenReturn(clientUpdated);
        when(clientRepository.saveClient(clientUpdated))
                .thenReturn(clientUpdated);

        Client client1 = clientUseCase.updatedClient(clientUpdated);

        assertEquals(1, client1.getId());

    }
}
