package ec.edu.ups.directvservice.entity;

import javax.persistence.*;

@Entity
public class PromotionDetail {
    @Id
    @SequenceGenerator(name = "seqPromotionDetail", sequenceName = "seqPromotionDetailId", initialValue = 1)
    @GeneratedValue(generator = "seqPromotionDetail")
    private long prd_id;

    @ManyToOne
    @JoinColumn(name = "pro_id")
    private Promotion promotion;

    private String prd_promo_url;

    public PromotionDetail() {
    }

    public PromotionDetail(long prd_id, String prd_promo_url) {
        this.prd_id = prd_id;
        this.prd_promo_url = prd_promo_url;
    }

    public PromotionDetail(String prd_promo_url) {
        this.prd_promo_url = prd_promo_url;
    }

    public long getPrd_id() {
        return prd_id;
    }

    public void setPrd_id(long prd_id) {
        this.prd_id = prd_id;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public String getPrd_promo_url() {
        return prd_promo_url;
    }

    public void setPrd_promo_url(String prd_promo_url) {
        this.prd_promo_url = prd_promo_url;
    }
}
