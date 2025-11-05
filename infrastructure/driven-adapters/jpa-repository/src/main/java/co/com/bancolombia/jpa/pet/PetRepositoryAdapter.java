package co.com.bancolombia.jpa.pet;

import co.com.bancolombia.jpa.helper.AdapterOperations;
import co.com.bancolombia.model.pet.Pet;
import co.com.bancolombia.model.pet.gateways.PetRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class PetRepositoryAdapter extends AdapterOperations<Pet, PetData, Long, PetDataRepository>
implements PetRepository
{

    public PetRepositoryAdapter(PetDataRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Pet.class));
    }

    @Override
    public Pet savePet(Pet pet) {
        return super.save(pet);
    }

    @Override
    public List<Pet> getAll() {
        return super.findAll();
    }

    @Override
    public void deletePet(Long id) {
        Pet pet = super.findById(id);
        if(Objects.isNull(pet)){
            repository.deleteById(id);
        }

    }
}
