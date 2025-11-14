package co.com.bancolombia.api.dto.response.models.pets;

import co.com.bancolombia.api.dto.response.models.client.ClientRSDTO;

import java.time.LocalDate;

public record CreatePetRSDTO(
        Long id,
        String name,
        String specie,
        String breed,
        LocalDate bornDate,
        ClientRSDTO client
) {
}
