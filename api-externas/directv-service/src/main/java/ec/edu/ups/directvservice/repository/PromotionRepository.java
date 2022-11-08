package ec.edu.ups.directvservice.repository;

import ec.edu.ups.directvservice.entity.Promotion;
import ec.edu.ups.directvservice.entity.ServiceDirectv;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface PromotionRepository extends CrudRepository<Promotion, Long> {
    @Query("Select T0 From Promotion T0 Where T0.pro_promo_desde <= :fecha and T0.pro_promo_hasta >= :fecha")
    List<Promotion> findServicesByFecha(LocalDate fecha);
}
