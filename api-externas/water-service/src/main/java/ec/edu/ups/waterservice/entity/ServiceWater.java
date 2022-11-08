package ec.edu.ups.waterservice.entity;

import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class ServiceWater {
    @Id
    @SequenceGenerator(name = "seqService", sequenceName = "seqServiceId", initialValue = 1)
    @GeneratedValue(generator = "seqService")
    private long id;

    @ManyToOne
    @JoinColumn(name = "contratoId")
    private Contract contract;

    private Double valorTotal;

    private Double valorMinimo;

    private LocalDate fechaEmision;

    private LocalDate fechaCorte;

    private LocalDate fechaMaxPago;

    @Nationalized
    private String observacion;

    private Boolean tieneMora;

    private Double montoMora;

    private Boolean tieneIntereses;

    private Double montoIntereses;

    public ServiceWater() {}
    public ServiceWater(long id, Double valorTotal, Double valorMinimo, LocalDate fechaEmision, LocalDate fechaCorte, LocalDate fechaMaxPago, String observacion, Boolean tieneMora, Double montoMora, Boolean tieneIntereses, Double montoIntereses) {
        this.id = id;
        this.valorTotal = valorTotal;
        this.valorMinimo = valorMinimo;
        this.fechaEmision = fechaEmision;
        this.fechaCorte = fechaCorte;
        this.fechaMaxPago = fechaMaxPago;
        this.observacion = observacion;
        this.tieneMora = tieneMora;
        this.montoMora = montoMora;
        this.tieneIntereses = tieneIntereses;
        this.montoIntereses = montoIntereses;
    }
    public ServiceWater(Double valorTotal, Double valorMinimo, LocalDate fechaEmision, LocalDate fechaCorte, LocalDate fechaMaxPago, String observacion, Boolean tieneMora, Double montoMora, Boolean tieneIntereses, Double montoIntereses) {
        this.valorTotal = valorTotal;
        this.valorMinimo = valorMinimo;
        this.fechaEmision = fechaEmision;
        this.fechaCorte = fechaCorte;
        this.fechaMaxPago = fechaMaxPago;
        this.observacion = observacion;
        this.tieneMora = tieneMora;
        this.montoMora = montoMora;
        this.tieneIntereses = tieneIntereses;
        this.montoIntereses = montoIntereses;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Double getValorMinimo() {
        return valorMinimo;
    }

    public void setValorMinimo(Double valorMinimo) {
        this.valorMinimo = valorMinimo;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public LocalDate getFechaCorte() {
        return fechaCorte;
    }

    public void setFechaCorte(LocalDate fechaCorte) {
        this.fechaCorte = fechaCorte;
    }

    public LocalDate getFechaMaxPago() {
        return fechaMaxPago;
    }

    public void setFechaMaxPago(LocalDate fechaMaxPago) {
        this.fechaMaxPago = fechaMaxPago;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Boolean getTieneMora() {
        return tieneMora;
    }

    public void setTieneMora(Boolean tieneMora) {
        this.tieneMora = tieneMora;
    }

    public Double getMontoMora() {
        return montoMora;
    }

    public void setMontoMora(Double montoMora) {
        this.montoMora = montoMora;
    }

    public Boolean getTieneIntereses() {
        return tieneIntereses;
    }

    public void setTieneIntereses(Boolean tieneIntereses) {
        this.tieneIntereses = tieneIntereses;
    }

    public Double getMontoIntereses() {
        return montoIntereses;
    }

    public void setMontoIntereses(Double montoIntereses) {
        this.montoIntereses = montoIntereses;
    }
}
