package ec.edu.ups.directvservice.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Promotion {
    @Id
    @SequenceGenerator(name = "seqPromotion", sequenceName = "seqPromotionId", initialValue = 1)
    @GeneratedValue(generator = "seqPromotion")
    private long pro_id;

    private String pro_promo_titulo;
    private String pro_promo_detalle;
    private String pro_promo_url;
    private LocalDate pro_promo_desde;
    private LocalDate pro_promo_hasta;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "promotion", cascade = CascadeType.ALL)
    private List<PromotionDetail> promotionDetails;

    public Promotion() {
    }

    public Promotion(long pro_id, String pro_promo_titulo, String pro_promo_detalle, String pro_promo_url, LocalDate pro_promo_desde, LocalDate pro_promo_hasta) {
        this.pro_id = pro_id;
        this.pro_promo_titulo = pro_promo_titulo;
        this.pro_promo_detalle = pro_promo_detalle;
        this.pro_promo_url = pro_promo_url;
        this.pro_promo_desde = pro_promo_desde;
        this.pro_promo_hasta = pro_promo_hasta;
    }

    public Promotion(String pro_promo_titulo, String pro_promo_detalle, String pro_promo_url, LocalDate pro_promo_desde, LocalDate pro_promo_hasta) {
        this.pro_promo_titulo = pro_promo_titulo;
        this.pro_promo_detalle = pro_promo_detalle;
        this.pro_promo_url = pro_promo_url;
        this.pro_promo_desde = pro_promo_desde;
        this.pro_promo_hasta = pro_promo_hasta;
    }

    public long getPro_id() {
        return pro_id;
    }

    public void setPro_id(long pro_id) {
        this.pro_id = pro_id;
    }

    public String getPro_promo_titulo() {
        return pro_promo_titulo;
    }

    public void setPro_promo_titulo(String pro_promo_titulo) {
        this.pro_promo_titulo = pro_promo_titulo;
    }

    public String getPro_promo_detalle() {
        return pro_promo_detalle;
    }

    public void setPro_promo_detalle(String pro_promo_detalle) {
        this.pro_promo_detalle = pro_promo_detalle;
    }

    public String getPro_promo_url() {
        return pro_promo_url;
    }

    public void setPro_promo_url(String pro_promo_url) {
        this.pro_promo_url = pro_promo_url;
    }

    public LocalDate getPro_promo_desde() {
        return pro_promo_desde;
    }

    public void setPro_promo_desde(LocalDate pro_promo_desde) {
        this.pro_promo_desde = pro_promo_desde;
    }

    public LocalDate getPro_promo_hasta() {
        return pro_promo_hasta;
    }

    public void setPro_promo_hasta(LocalDate pro_promo_hasta) {
        this.pro_promo_hasta = pro_promo_hasta;
    }

    public List<PromotionDetail> getPromotionDetails() {
        return promotionDetails;
    }

    public void setPromotionDetails(List<PromotionDetail> promotionDetails) {
        this.promotionDetails = promotionDetails;
    }
}
