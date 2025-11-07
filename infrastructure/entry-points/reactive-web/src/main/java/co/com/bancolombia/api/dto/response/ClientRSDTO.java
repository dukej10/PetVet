package co.com.bancolombia.api.dto.response;

import java.time.LocalDateTime;

public record ClientRSDTO(Long id, String name, String lastName, String phone, String email, String address) {
}
