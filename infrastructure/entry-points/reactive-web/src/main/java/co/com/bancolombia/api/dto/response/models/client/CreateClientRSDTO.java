package co.com.bancolombia.api.dto.response.models.client;

import java.time.LocalDateTime;

public record CreateClientRSDTO(Long id, String name, String lastName, String phone, String email, String address,
                                LocalDateTime createdDate) {
}
