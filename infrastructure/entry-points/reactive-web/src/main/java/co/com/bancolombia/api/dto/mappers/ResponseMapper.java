package co.com.bancolombia.api.dto.mappers;


import co.com.bancolombia.api.dto.response.models.appointment.AppointmentRSDTO;
import co.com.bancolombia.api.dto.response.models.appointment.CreatedAppointmentRSDTO;
import co.com.bancolombia.api.dto.response.models.client.ClientRSDTO;
import co.com.bancolombia.api.dto.response.models.client.CreateClientRSDTO;
import co.com.bancolombia.api.dto.response.models.pets.CreatePetRSDTO;
import co.com.bancolombia.api.dto.response.models.pets.PetRSDTO;
import co.com.bancolombia.model.appointment.Appointment;
import co.com.bancolombia.model.client.Client;
import co.com.bancolombia.model.pet.Pet;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ResponseMapper {
    ClientRSDTO toResponse(Client client);
    PetRSDTO toResponse(Pet pet);
    AppointmentRSDTO toResponse(Appointment appointment);
    CreatePetRSDTO toResponseFull(Pet pet);
    CreateClientRSDTO toResponseFull(Client client);
    CreatedAppointmentRSDTO toResponseFull(Appointment appointment);
    List<ClientRSDTO> toRSList(List<Client> clients);
    List<PetRSDTO> toRSListPets(List<Pet> pets);
    List<AppointmentRSDTO> toRSListApp (List<Appointment> appointments);
}
