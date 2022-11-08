package ec.edu.ups.directvservice.entity.request;

import ec.edu.ups.directvservice.entity.PromotionDetail;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

public class PromotionDTO {
    private long id;
    private String promo_titulo;
    private String promo_detalle;
    private String promo_url;
    private LocalDate promo_desde;
    private LocalDate promo_hasta;
    private List<GaleriaDTO> galeria;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPromo_titulo() {
        return promo_titulo;
    }

    public void setPromo_titulo(String promo_titulo) {
        this.promo_titulo = promo_titulo;
    }

    public String getPromo_detalle() {
        return promo_detalle;
    }

    public void setPromo_detalle(String promo_detalle) {
        this.promo_detalle = promo_detalle;
    }

    public String getPromo_url() {
        return promo_url;
    }

    public void setPromo_url(String promo_url) {
        this.promo_url = promo_url;
    }

    public LocalDate getPromo_desde() {
        return promo_desde;
    }

    public void setPromo_desde(LocalDate promo_desde) {
        this.promo_desde = promo_desde;
    }

    public LocalDate getPromo_hasta() {
        return promo_hasta;
    }

    public void setPromo_hasta(LocalDate promo_hasta) {
        this.promo_hasta = promo_hasta;
    }

    public List<GaleriaDTO> getGaleria() {
        return galeria;
    }

    public void setGaleria(List<GaleriaDTO> galeria) {
        this.galeria = galeria;
    }
}
