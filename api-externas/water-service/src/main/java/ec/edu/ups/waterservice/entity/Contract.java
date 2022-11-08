package ec.edu.ups.waterservice.entity;

import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Contract {
    @Id
    @SequenceGenerator(name = "seqContract", sequenceName = "seqContractId", initialValue = 1)
    @GeneratedValue(generator = "seqContract")
    private long id;

    @ManyToOne
    @JoinColumn(name = "clienteId")
    private Customer customer;

    @Nationalized
    private String direccionDomicilio;

    private LocalDate fecha;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "contract", cascade = CascadeType.ALL)
    private List<ServiceWater> servicesWater;

    public Contract() { }
    public Contract(long id, String direccionDomicilio, LocalDate fecha) {
        this.id = id;
        this.direccionDomicilio = direccionDomicilio;
        this.fecha = fecha;
    }
    public Contract(String direccionDomicilio, LocalDate fecha) {
        this.direccionDomicilio = direccionDomicilio;
        this.fecha = fecha;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    public String getDireccionDomicilio() {
        return direccionDomicilio;
    }

    public void setDireccionDomicilio(String direccionDomicilio) {
        this.direccionDomicilio = direccionDomicilio;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public List<ServiceWater> getServicesWater() {
        return servicesWater;
    }

    public void setServicesWater(List<ServiceWater> servicesWater) {
        this.servicesWater = servicesWater;
    }


}
