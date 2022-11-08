package ec.edu.ups.directvservice.repository;

import ec.edu.ups.directvservice.entity.ServiceDirectv;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ServiceDirectvRepository extends CrudRepository<ServiceDirectv, Long> {
    @Query("Select T0 From ServiceDirectv T0 Join T0.contract T1 Join T1.customer T2 Where T2.cli_cedula = :dni")
    List<ServiceDirectv> findServicesByDNI(String dni);
}
