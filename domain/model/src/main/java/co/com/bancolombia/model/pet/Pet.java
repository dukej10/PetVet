package co.com.bancolombia.model.pet;

import co.com.bancolombia.model.appointment.Appointment;
import co.com.bancolombia.model.client.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Pet {

    private Long id;

    private Client client;

    private List<Appointment> appointments;

    private String name;

    private String specie;

    private String breed;

    private String urlPhoto;

    private LocalDate bornDate;

    private String gender;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;
}
