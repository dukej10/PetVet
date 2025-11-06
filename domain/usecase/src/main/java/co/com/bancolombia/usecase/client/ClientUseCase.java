package co.com.bancolombia.usecase.client;

import co.com.bancolombia.model.client.Client;
import co.com.bancolombia.model.client.gateways.ClientRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ClientUseCase {
    private final ClientRepository repository;

    public Client saveClient(Client client) {
        try {
            return repository.saveClient(client);
        } catch (Exception ex) {
            return null;
        }
    }

    public Client updatedClient(Client client) {
        try {
            return repository.saveClient(client);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public Client getById(Long id) {
        return repository.findById(id);
    }

    public List<Client> getAllClients() {
        return repository.getAll();
    }

}
