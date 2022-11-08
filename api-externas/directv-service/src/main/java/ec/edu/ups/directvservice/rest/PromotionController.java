package ec.edu.ups.directvservice.rest;

import ec.edu.ups.directvservice.entity.Promotion;
import ec.edu.ups.directvservice.entity.PromotionDetail;
import ec.edu.ups.directvservice.entity.ServiceDirectv;
import ec.edu.ups.directvservice.entity.request.GaleriaDTO;
import ec.edu.ups.directvservice.entity.request.PromotionDTO;
import ec.edu.ups.directvservice.entity.request.ServiceDirectvDTO;
import ec.edu.ups.directvservice.service.PromotionService;
import ec.edu.ups.directvservice.service.ServiceDirectvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/servicio_api")
public class PromotionController {
    @Autowired
    PromotionService promotionService;

    private PromotionDTO convertPromotionToPromotionDTO(Promotion promotion){
        PromotionDTO promotionDTO = new PromotionDTO();
        promotionDTO.setId(promotion.getPro_id());
        promotionDTO.setPromo_desde(promotion.getPro_promo_desde());
        promotionDTO.setPromo_hasta(promotion.getPro_promo_hasta());
        promotionDTO.setPromo_titulo(promotion.getPro_promo_titulo());
        promotionDTO.setPromo_detalle(promotion.getPro_promo_detalle());
        promotionDTO.setPromo_url(promotion.getPro_promo_url());
        List<GaleriaDTO> galeriaDTOList = new ArrayList<>();
        GaleriaDTO galeriaDTO;
        for(PromotionDetail promotionDetail: promotion.getPromotionDetails()){
            galeriaDTO = new GaleriaDTO();
            galeriaDTO.setId(promotionDTO.getId());
            galeriaDTO.setPromo_url(promotionDetail.getPrd_promo_url());
            galeriaDTOList.add(galeriaDTO);
        }
        promotionDTO.setGaleria(galeriaDTOList);
        return promotionDTO;
    }
    @GetMapping("/promocion/{fecha}")
    public List<PromotionDTO> getPromotionsByFecha(@PathVariable String fecha){
        List<PromotionDTO> promotionDTOList = new ArrayList<>();
        List<Promotion> promotionList = promotionService.retrievePromotionByDate(LocalDate.parse(fecha));
        PromotionDTO promotionDTO;
        for(Promotion promotion : promotionList){
            promotionDTO = convertPromotionToPromotionDTO(promotion);
            promotionDTOList.add(promotionDTO);
        }
        return promotionDTOList;
    }
}
