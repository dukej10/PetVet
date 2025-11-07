package co.com.bancolombia.jpa.client;

import co.com.bancolombia.jpa.helper.AdapterOperations;
import co.com.bancolombia.model.client.Client;
import co.com.bancolombia.model.client.gateways.ClientRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class ClientRepositoryAdapter extends AdapterOperations<Client, ClientData, Long, ClientDataRepository>
implements ClientRepository
{

    public ClientRepositoryAdapter(ClientDataRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Client.class));
    }

    @Override
    public Client saveClient(Client client) {
        return super.save(client);
    }

    @Override
    public List<Client> getAll() {
        return super.findAll();
    }

    @Override
    public void deleteClient(Long id) {
        Client client = super.findById(id);
        if(Objects.isNull(client)){
            repository.deleteById(id);
        }

    }
}
