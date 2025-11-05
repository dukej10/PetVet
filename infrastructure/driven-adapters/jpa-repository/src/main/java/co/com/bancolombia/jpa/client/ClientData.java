package co.com.bancolombia.jpa.client;

import co.com.bancolombia.jpa.pet.PetData;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="clients")
public class ClientData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(name="last_name",length = 100, nullable = false)
    private String lastName;

    @Column(length = 20, nullable = false)
    private String phone;

    @Column(length = 100)
    private String email;

    @Column(length = 100, nullable = false)
    String address;

    @OneToMany(mappedBy = "client")
    private List<PetData> pets;

    @Column(name= "created_at")
    LocalDateTime createdDate;

    @PrePersist
    public void prePersist() {
        createdDate = LocalDateTime.now();
    }


}
