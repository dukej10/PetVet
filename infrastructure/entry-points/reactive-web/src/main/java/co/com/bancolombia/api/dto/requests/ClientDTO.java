package co.com.bancolombia.api.dto.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ClientDTO implements Serializable {

    @NotBlank
    @Size(max=15)
    private String name;

    @NotBlank
    private String lastName;

    @NotBlank
    private String phone;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String address;

}
