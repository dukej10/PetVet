package co.com.bancolombia.jpa.client;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface ClientDataRepository extends CrudRepository<ClientData, Long>, QueryByExampleExecutor<ClientData> {
    ClientData findByName(String name);
}
