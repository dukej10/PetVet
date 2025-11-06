package co.com.bancolombia.api.dto.mappers;

import co.com.bancolombia.api.dto.requests.ClientDTO;
import co.com.bancolombia.api.dto.requests.PetDTO;
import co.com.bancolombia.model.appointment.Appointment;
import co.com.bancolombia.model.client.Client;
import co.com.bancolombia.model.pet.Pet;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DTOtoModelMapper {

    Client toModel(ClientDTO clientDTO);
    Pet toModel(PetDTO petDTO);
}
