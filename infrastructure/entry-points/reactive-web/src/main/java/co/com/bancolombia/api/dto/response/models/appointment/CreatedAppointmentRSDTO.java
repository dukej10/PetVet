package co.com.bancolombia.api.dto.response.models.appointment;

import co.com.bancolombia.api.dto.response.models.pets.PetRSDTO;

public record CreatedAppointmentRSDTO(
       AppointmentRSDTO appointment,
       PetRSDTO pet
){ }
