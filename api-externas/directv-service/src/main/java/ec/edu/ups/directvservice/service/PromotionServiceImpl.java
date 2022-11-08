package ec.edu.ups.directvservice.service;

import ec.edu.ups.directvservice.entity.Promotion;
import ec.edu.ups.directvservice.entity.ServiceDirectv;
import ec.edu.ups.directvservice.repository.PromotionRepository;
import ec.edu.ups.directvservice.repository.ServiceDirectvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PromotionServiceImpl implements PromotionService{
    @Autowired
    PromotionRepository promotionRepository;

    @Override
    public List<Promotion> retrievePromotionByDate(LocalDate fecha) {
        return (List<Promotion>)promotionRepository.findServicesByFecha(fecha);
    }
}
