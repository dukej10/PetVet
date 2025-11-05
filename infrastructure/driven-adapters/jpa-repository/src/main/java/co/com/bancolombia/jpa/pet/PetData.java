package co.com.bancolombia.jpa.pet;

import co.com.bancolombia.jpa.appointment.AppointmentData;
import co.com.bancolombia.jpa.client.ClientData;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "pets")
public class PetData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private ClientData client;

    @OneToMany(mappedBy = "pet")
    private List<AppointmentData> appointments;

    @Column(length = 50)
    private String name;

    private String specie;

    private String breed;

    @Column(name="pet_photo")
    private String urlPhoto;

    @Column(name = "born_date", length = 10, nullable = false)
    private LocalDate  bornDate;

    @Column(length = 10)
    private String gender;

}
