package co.com.bancolombia.api.dto.mappers;


import co.com.bancolombia.api.dto.requests.ClientDTO;
import co.com.bancolombia.api.dto.requests.PetDTO;
import co.com.bancolombia.api.dto.response.ClientRSDTO;
import co.com.bancolombia.api.dto.response.CreateClientRSDTO;
import co.com.bancolombia.api.dto.response.CreatePetRSDTO;
import co.com.bancolombia.api.dto.response.PetRSDTO;
import co.com.bancolombia.model.client.Client;
import co.com.bancolombia.model.pet.Pet;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ResponseMapper {
    ClientRSDTO toResponse(Client client);
    PetRSDTO toResponse(Pet pet);
    CreatePetRSDTO toResponseFull(Pet pet);
    CreateClientRSDTO toResponseFull(Client client);
    List<ClientRSDTO> toRSList(List<Client> clients);
}
