package co.com.bancolombia.jpa.pet;

import co.com.bancolombia.jpa.client.ClientData;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface PetDataRepository extends CrudRepository<PetData, Long>, QueryByExampleExecutor<PetData> {
    ClientData findByName(String name);

    @Query("""
        SELECT p 
        FROM PetData p
        JOIN p.appointments a
        GROUP BY p
        ORDER BY COUNT(a) DESC
        LIMIT 1
        """)
    PetData findPetWithMostAppointments();
}
