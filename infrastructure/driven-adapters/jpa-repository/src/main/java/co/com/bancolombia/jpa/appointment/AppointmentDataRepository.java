package co.com.bancolombia.jpa.appointment;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface AppointmentDataRepository extends CrudRepository<AppointmentData, Long>,
        QueryByExampleExecutor<AppointmentData> {

}
