package co.com.bancolombia.model.appointment;

import co.com.bancolombia.model.pet.Pet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Appointment {

    private Long id;

    private Pet pet;

    LocalDateTime dateTime;

    private String reason;

    private String state;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;
}
