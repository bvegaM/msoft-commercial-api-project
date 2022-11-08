package ec.edu.ups.servicesconsume.entity.dto;

import ec.edu.ups.servicesconsume.entity.respone.ResponseUserPromotions;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class S0002_DirectvPromotionDTO {

    private Long id;
    private String promo_titulo;
    private String promo_detalle;
    private String promo_url;
    private LocalDate promo_desde;
    private LocalDate promo_hasta;
    private List<S0002_DirectvPromotionGaleriaDTO> galeria;


    public S0002_DirectvPromotionDTO() { }

    public S0002_DirectvPromotionDTO(Long id, String promo_titulo, String promo_detalle, String promo_url, LocalDate promo_desde, LocalDate promo_hasta) {
        this.id = id;
        this.promo_titulo = promo_titulo;
        this.promo_detalle = promo_detalle;
        this.promo_url = promo_url;
        this.promo_desde = promo_desde;
        this.promo_hasta = promo_hasta;
    }


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPromo_titulo() { return promo_titulo; }
    public void setPromo_titulo(String promo_titulo) { this.promo_titulo = promo_titulo; }

    public String getPromo_detalle() { return promo_detalle; }
    public void setPromo_detalle(String promo_detalle) { this.promo_detalle = promo_detalle; }

    public String getPromo_url() { return promo_url; }
    public void setPromo_url(String promo_url) { this.promo_url = promo_url; }

    public LocalDate getPromo_desde() { return promo_desde; }
    public void setPromo_desde(LocalDate promo_desde) { this.promo_desde = promo_desde; }

    public LocalDate getPromo_hasta() { return promo_hasta; }
    public void setPromo_hasta(LocalDate promo_hasta) { this.promo_hasta = promo_hasta; }

    public List<S0002_DirectvPromotionGaleriaDTO> getGaleria() { return galeria; }
    public void setGaleria(List<S0002_DirectvPromotionGaleriaDTO> galeria) { this.galeria = galeria; }


    public ResponseUserPromotions convertToResponseUser() {
        ResponseUserPromotions dto = new ResponseUserPromotions(this.promo_titulo, this.promo_detalle, this.promo_url, this.promo_desde, this.promo_hasta);
        if(this.galeria != null) {
            dto.setPictures(this.galeria.stream().map(S0002_DirectvPromotionGaleriaDTO::getPromo_url).collect(Collectors.toList()));
        }

        return dto;
    }


}
