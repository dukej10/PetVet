package co.com.bancolombia.api.dto.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AppointmentDTO {

    @NotBlank
    private Long idPet;

    @NotBlank
    private String reason;

    @NotBlank
    private String state;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime dateTime;
}
