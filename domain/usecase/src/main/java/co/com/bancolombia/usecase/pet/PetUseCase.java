package co.com.bancolombia.usecase.pet;

import co.com.bancolombia.model.client.Client;
import co.com.bancolombia.model.client.gateways.ClientRepository;
import co.com.bancolombia.model.exceptions.GeneralException;
import co.com.bancolombia.model.exceptions.NoDataFoundException;
import co.com.bancolombia.model.pet.Pet;
import co.com.bancolombia.model.pet.gateways.PetRepository;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@RequiredArgsConstructor
public class PetUseCase {
    private final PetRepository repository;
    private final ClientRepository clientRepository;

    public Pet savePet(Pet pet, Long idClient) {
        try {
                Client client = getClientById(idClient);
                pet.setClient(client);
                return repository.savePet(pet);
            } catch (Exception ex) {
            throw new GeneralException("Error al guardar la mascota");
        }
    }

    private Client getClientById(Long idClient) {
        Client client = clientRepository.findById(idClient);
        if (client == null) {
            throw new NoDataFoundException();
        }
        return client;
    }

    public Pet updatedPet(Pet pet, Long idClient) {
        try {
            Pet petFound = getById(pet.getId());
            pet.setId(petFound.getId());
            pet.setUpdatedDate(LocalDateTime.now());
            return repository.savePet(pet);
        } catch (Exception ex) {
            throw new GeneralException("Error al actualizar la mascota");
        }
    }

    public Pet getById(Long id) {

            Pet pet =  repository.findById(id);
            if(pet == null){
                throw new NoDataFoundException();
            }
            return pet;
    }

    public List<Pet> getAllPets() {
        try {
            return repository.getAll();
        } catch (Exception ex) {
            throw new GeneralException("Error al obtener las mascotas");
        }
    }
}
