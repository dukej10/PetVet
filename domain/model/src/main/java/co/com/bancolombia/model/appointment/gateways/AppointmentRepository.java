package co.com.bancolombia.model.appointment.gateways;

import co.com.bancolombia.model.appointment.Appointment;

import java.util.List;

public interface AppointmentRepository {

    Appointment saveAppointment(Appointment appointment);

    List<Appointment> getAll();

    void deleteAppointment (Long id);

    Appointment findById(Long id);
}
