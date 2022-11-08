package ec.edu.ups.servicesconsume.entity.dto;

public class S0002_DirectvPromotionGaleriaDTO {

    private Long id;
    private String promo_url;


    public S0002_DirectvPromotionGaleriaDTO() { }

    public S0002_DirectvPromotionGaleriaDTO(Long id, String promo_url) {
        this.id = id;
        this.promo_url = promo_url;
    }


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPromo_url() { return promo_url; }
    public void setPromo_url(String promo_url) { this.promo_url = promo_url; }


}
