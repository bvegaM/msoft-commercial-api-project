package ec.edu.ups.directvservice.entity;

import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Contract {
    @Id
    @SequenceGenerator(name = "seqContract", sequenceName = "seqContractId", initialValue = 1)
    @GeneratedValue(generator = "seqContract")
    private long cnt_id;

    @ManyToOne
    @JoinColumn(name = "cli_id")
    private Customer customer;

    @Nationalized
    private String cnt_direccion;

    private LocalDate cnt_fecha;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "contract", cascade = CascadeType.ALL)
    private List<ServiceDirectv> serviceDirectvs;

    public Contract() { }
    public Contract(long cnt_id, String cnt_direccion, LocalDate cnt_fecha) {
        this.cnt_id = cnt_id;
        this.cnt_direccion = cnt_direccion;
        this.cnt_fecha = cnt_fecha;
    }
    public Contract(String cnt_direccion, LocalDate cnt_fecha) {
        this.cnt_direccion = cnt_direccion;
        this.cnt_fecha = cnt_fecha;
    }

    public long getCnt_id() {
        return cnt_id;
    }

    public void setCnt_id(long cnt_id) {
        this.cnt_id = cnt_id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getCnt_direccion() {
        return cnt_direccion;
    }

    public void setCnt_direccion(String cnt_direccion) {
        this.cnt_direccion = cnt_direccion;
    }

    public LocalDate getCnt_fecha() {
        return cnt_fecha;
    }

    public void setCnt_fecha(LocalDate cnt_fecha) {
        this.cnt_fecha = cnt_fecha;
    }

    public List<ServiceDirectv> getServiceDirectvs() {
        return serviceDirectvs;
    }

    public void setServiceDirectvs(List<ServiceDirectv> serviceDirectvs) {
        this.serviceDirectvs = serviceDirectvs;
    }
}
