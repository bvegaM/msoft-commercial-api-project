package ec.edu.ups.waterservice.repository;

import ec.edu.ups.waterservice.entity.Contract;
import ec.edu.ups.waterservice.entity.ServiceWater;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContractRepository extends CrudRepository<Contract, Long> {
    @Query("Select T0 From Contract T0 Join T0.customer T1 Where T1.cedula = :cedula")
    List<Contract> findContractsByCedula(String cedula);
}
