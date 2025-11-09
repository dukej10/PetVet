package co.com.bancolombia.model.client;

import co.com.bancolombia.model.pet.Pet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Client {

    private Long id;

    private String name;

    private String lastName;

    private String phone;

    private String email;

    private String address;

    private List<Pet> pets;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;
}
