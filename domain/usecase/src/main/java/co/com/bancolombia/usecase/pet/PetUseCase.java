package co.com.bancolombia.usecase.pet;

import co.com.bancolombia.model.client.Client;
import co.com.bancolombia.model.client.gateways.ClientRepository;
import co.com.bancolombia.model.pet.Pet;
import co.com.bancolombia.model.pet.gateways.PetRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;


@RequiredArgsConstructor
public class PetUseCase {
    private final PetRepository repository;
    private final ClientRepository clientRepository;

    public Pet savePet(Pet pet, Long idClient) {
        try {
            Client client = clientRepository.findById(idClient);
            if(client != null){
                pet.setClient(client);
                return repository.savePet(pet);

            }
            return null;
        } catch (Exception ex) {
            return null;
        }
    }

    public Pet updatedPet(Pet pet) {
        try {
            return repository.savePet(pet);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public Pet getById(Long id) {
        return repository.findById(id);
    }

    public List<Pet> getAllPets() {
        return repository.getAll();
    }
}
