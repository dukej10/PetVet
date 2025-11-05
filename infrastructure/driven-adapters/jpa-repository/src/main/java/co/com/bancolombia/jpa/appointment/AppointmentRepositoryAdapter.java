package co.com.bancolombia.jpa.appointment;

import co.com.bancolombia.jpa.helper.AdapterOperations;
import co.com.bancolombia.model.appointment.Appointment;
import co.com.bancolombia.model.appointment.gateways.AppointmentRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class AppointmentRepositoryAdapter
        extends AdapterOperations<Appointment, AppointmentData, Long, AppointmentDataRepository>
implements AppointmentRepository
{

    public AppointmentRepositoryAdapter(AppointmentDataRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Appointment.class));
    }

    @Override
    public Appointment saveAppointment(Appointment Appointment) {
        return super.save(Appointment);
    }

    @Override
    public List<Appointment> getAll() {
        return super.findAll();
    }

    @Override
    public void deleteAppointment(Long id) {
        Appointment appointment = super.findById(id);
        if(Objects.isNull(appointment)){
            repository.deleteById(id);
        }

    }
}
