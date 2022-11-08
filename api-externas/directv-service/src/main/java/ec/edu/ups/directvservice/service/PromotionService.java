package ec.edu.ups.directvservice.service;

import ec.edu.ups.directvservice.entity.Promotion;
import ec.edu.ups.directvservice.entity.ServiceDirectv;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;


public interface PromotionService {
    List<Promotion> retrievePromotionByDate(LocalDate fecha);
}
