package co.com.bancolombia.model.client.gateways;

import co.com.bancolombia.model.client.Client;

import java.util.List;

public interface ClientRepository {

    Client saveClient(Client client);

    List<Client> getAll();

    void deleteClient (Long id);

    Client findById(Long id);
}
