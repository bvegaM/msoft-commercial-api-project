package ec.edu.ups.waterservice.repository;

import ec.edu.ups.waterservice.entity.ServiceWater;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ServiceWaterRepository extends CrudRepository<ServiceWater, Long> {
    @Query("Select T0 From ServiceWater T0 Join T0.contract T1 Join T1.customer T2 Where T2.cedula = :cedula")
    List<ServiceWater> findServicesByCedula(String cedula);

    @Query("Select T0 From ServiceWater T0 Join T0.contract T1 Where T1.id = :contractId")
    List<ServiceWater> findServicesByContract(Long contractId);
}
