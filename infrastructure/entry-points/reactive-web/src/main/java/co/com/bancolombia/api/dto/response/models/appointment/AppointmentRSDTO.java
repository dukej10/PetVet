package co.com.bancolombia.api.dto.response.models.appointment;

import co.com.bancolombia.model.pet.Pet;

import java.time.LocalDateTime;

public record AppointmentRSDTO (
         Long id,
         Pet pet,
         LocalDateTime dateTime,
         String reason,
         String state
){ }
