package co.com.bancolombia.usecase.appointment;

import co.com.bancolombia.model.appointment.Appointment;
import co.com.bancolombia.model.appointment.gateways.AppointmentRepository;
import co.com.bancolombia.model.exceptions.GeneralException;
import co.com.bancolombia.model.exceptions.NoDataFoundException;
import co.com.bancolombia.model.pet.Pet;
import co.com.bancolombia.model.pet.gateways.PetRepository;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class AppointmentUseCase {
    private final AppointmentRepository appointmentRepository;
    private final PetRepository petRepository;

    public Appointment save(Appointment appointment, Long idPet) {
        try {
            Pet petFound = getByPetId(idPet);
            appointment.setPet(petFound);
            return appointmentRepository.saveAppointment(appointment);
        } catch (Exception e) {
            throw new GeneralException("Error al guardar la cita");
        }
    }

    public Appointment update(Appointment appointment, Long idPet) {
        try {
            Pet petFound = getByPetId(idPet);
            Appointment appointmentFound = getById(appointment.getId());
            structureUpdated(appointment, appointmentFound);
            return appointmentRepository.saveAppointment(appointment);

        } catch (Exception e) {
            throw new GeneralException("Error al actualizar la cita");
        }
    }

    private static void structureUpdated(Appointment appointment, Appointment appointmentFound) {
        appointment.setId(appointmentFound.getId());
        appointment.setCreatedDate(appointmentFound.getCreatedDate());
        appointment.setPet(appointmentFound.getPet());
        appointment.setUpdatedDate(LocalDateTime.now());
    }

    private Pet getByPetId(Long id) {

        Pet pet =  petRepository.findById(id);
        if(pet == null){
            throw new NoDataFoundException();
        }
        return pet;
    }

    public Appointment getById(Long id) {
        Appointment appointment = appointmentRepository.findById(id);
        if (appointment == null) throw  new NoDataFoundException();
        return appointment;
    }


}
