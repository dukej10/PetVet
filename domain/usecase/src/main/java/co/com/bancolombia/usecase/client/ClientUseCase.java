package co.com.bancolombia.usecase.client;

import co.com.bancolombia.model.client.Client;
import co.com.bancolombia.model.client.gateways.ClientRepository;
import co.com.bancolombia.model.exceptions.NoDataFoundException;
import lombok.RequiredArgsConstructor;
import java.time.LocalDateTime;


import java.util.List;

@RequiredArgsConstructor
public class ClientUseCase {
    private final ClientRepository repository;

    public Client saveClient(Client client) {
        try {
            return repository.saveClient(client);
        } catch (Exception ex) {
            throw new NoDataFoundException();
        }
    }

    public Client updatedClient(Client client) {
        try {
            Client clientFound = getById(client.getId());
            if (clientFound != null) {
                clientFound.setUpdatedDate(LocalDateTime.now());
                return repository.saveClient(clientFound);
            }else {
                throw new NoDataFoundException();

            }
        } catch (Exception ex) {
            throw new NoDataFoundException();
        }
    }

    public Client  getById(Long id) {
       try {
           Client client = repository.findById(id);
           if(client != null) {
               return client;
           }
           throw new NoDataFoundException();
       } catch (Exception ex) {
           throw new NoDataFoundException();
       }
    }

    public List<Client> getAllClients() {
        try {
            return repository.getAll();

        } catch (Exception e) {
            throw new NoDataFoundException();
        }
    }

}
