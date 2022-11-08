package ec.edu.ups.servicesconsume.repository;

import ec.edu.ups.servicesconsume.entity.ServicePartner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ServicePartnerRepository extends CrudRepository<ServicePartner, Long> {


    public Optional<ServicePartner> findByCode(String code);



}
