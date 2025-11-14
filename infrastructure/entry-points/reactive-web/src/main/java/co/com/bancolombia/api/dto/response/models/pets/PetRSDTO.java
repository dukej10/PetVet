package co.com.bancolombia.api.dto.response.models.pets;

import java.time.LocalDate;

public record PetRSDTO (
        Long id,
        String name,
        String specie,
        String breed,
        LocalDate bornDate
) {
}
