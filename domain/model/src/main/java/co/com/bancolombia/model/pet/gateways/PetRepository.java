package co.com.bancolombia.model.pet.gateways;

import co.com.bancolombia.model.pet.Pet;

import java.util.List;

public interface PetRepository {

    Pet savePet(Pet pet);

    List<Pet> getAll();

    void deletePet (Long id);

    Pet findById(Long id);

    Pet findPetWithMostAppointments();
}
