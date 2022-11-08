package ec.edu.ups.directvservice.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class ServiceDirectv {
    @Id
    @SequenceGenerator(name = "seqService", sequenceName = "seqServiceId", initialValue = 1)
    @GeneratedValue(generator = "seqService")
    private long sdr_id;

    @ManyToOne
    @JoinColumn(name = "cnt_id")
    private Contract contract;

    private Double sdr_deuda_total;
    private Double sdr_deuda_minimo;
    private LocalDate sdr_deuda_emision;
    private LocalDate sdr_deuda_corte;
    private LocalDate sdr_deuda_vencimiento;
    private String  sdr_observacion;

    public ServiceDirectv() { }
    public ServiceDirectv(long sdr_id, Double sdr_deuda_total, Double sdr_deuda_minimo, LocalDate sdr_deuda_emision, LocalDate sdr_deuda_corte, LocalDate sdr_deuda_vencimiento, String sdr_observacion) {
        this.sdr_id = sdr_id;
        this.sdr_deuda_total = sdr_deuda_total;
        this.sdr_deuda_minimo = sdr_deuda_minimo;
        this.sdr_deuda_emision = sdr_deuda_emision;
        this.sdr_deuda_corte = sdr_deuda_corte;
        this.sdr_deuda_vencimiento = sdr_deuda_vencimiento;
        this.sdr_observacion = sdr_observacion;
    }
    public ServiceDirectv(Double sdr_deuda_total, Double sdr_deuda_minimo, LocalDate sdr_deuda_emision, LocalDate sdr_deuda_corte, LocalDate sdr_deuda_vencimiento, String sdr_observacion) {
        this.sdr_deuda_total = sdr_deuda_total;
        this.sdr_deuda_minimo = sdr_deuda_minimo;
        this.sdr_deuda_emision = sdr_deuda_emision;
        this.sdr_deuda_corte = sdr_deuda_corte;
        this.sdr_deuda_vencimiento = sdr_deuda_vencimiento;
        this.sdr_observacion = sdr_observacion;
    }

    public long getSdr_id() {
        return sdr_id;
    }

    public void setSdr_id(long sdr_id) {
        this.sdr_id = sdr_id;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Double getSdr_deuda_total() {
        return sdr_deuda_total;
    }

    public void setSdr_deuda_total(Double sdr_deuda_total) {
        this.sdr_deuda_total = sdr_deuda_total;
    }

    public Double getSdr_deuda_minimo() {
        return sdr_deuda_minimo;
    }

    public void setSdr_deuda_minimo(Double sdr_deuda_minimo) {
        this.sdr_deuda_minimo = sdr_deuda_minimo;
    }

    public LocalDate getSdr_deuda_emision() {
        return sdr_deuda_emision;
    }

    public void setSdr_deuda_emision(LocalDate sdr_deuda_emision) {
        this.sdr_deuda_emision = sdr_deuda_emision;
    }

    public LocalDate getSdr_deuda_corte() {
        return sdr_deuda_corte;
    }

    public void setSdr_deuda_corte(LocalDate sdr_deuda_corte) {
        this.sdr_deuda_corte = sdr_deuda_corte;
    }

    public LocalDate getSdr_deuda_vencimiento() {
        return sdr_deuda_vencimiento;
    }

    public void setSdr_deuda_vencimiento(LocalDate sdr_deuda_vencimiento) {
        this.sdr_deuda_vencimiento = sdr_deuda_vencimiento;
    }

    public String getSdr_observacion() {
        return sdr_observacion;
    }

    public void setSdr_observacion(String sdr_observacion) {
        this.sdr_observacion = sdr_observacion;
    }
}
