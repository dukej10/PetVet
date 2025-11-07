package co.com.bancolombia.api.dto.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class PetDTO implements Serializable {
    @NotNull
    Long idClient;

    @NotBlank
    String name;

    @NotBlank
    String specie;

    @NotBlank
    String breed;

    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate bornDate;

    @NotBlank
    String gender;
}

