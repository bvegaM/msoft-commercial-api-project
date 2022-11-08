package ec.edu.ups.directvservice.entity.request;

import ec.edu.ups.directvservice.entity.Contract;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

public class ServiceDirectvDTO {
    private long sdr_id;
    private String cli_dni;
    private Long cli_contrato;
    private String cli_nombres;
    private Double deuda_total;
    private Double deuda_minimo;
    private LocalDate deuda_emision;
    private LocalDate deuda_corte;
    private LocalDate deuda_vencimiento;
    private String  observacion;

    public long getSdr_id() {
        return sdr_id;
    }

    public void setSdr_id(long sdr_id) {
        this.sdr_id = sdr_id;
    }

    public String getCli_dni() {
        return cli_dni;
    }

    public void setCli_dni(String cli_dni) {
        this.cli_dni = cli_dni;
    }

    public Long getCli_contrato() {
        return cli_contrato;
    }

    public void setCli_contrato(Long cli_contrato) {
        this.cli_contrato = cli_contrato;
    }

    public String getCli_nombres() {
        return cli_nombres;
    }

    public void setCli_nombres(String cli_nombres) {
        this.cli_nombres = cli_nombres;
    }

    public Double getDeuda_total() {
        return deuda_total;
    }

    public void setDeuda_total(Double deuda_total) {
        this.deuda_total = deuda_total;
    }

    public Double getDeuda_minimo() {
        return deuda_minimo;
    }

    public void setDeuda_minimo(Double deuda_minimo) {
        this.deuda_minimo = deuda_minimo;
    }

    public LocalDate getDeuda_emision() {
        return deuda_emision;
    }

    public void setDeuda_emision(LocalDate deuda_emision) {
        this.deuda_emision = deuda_emision;
    }

    public LocalDate getDeuda_corte() {
        return deuda_corte;
    }

    public void setDeuda_corte(LocalDate deuda_corte) {
        this.deuda_corte = deuda_corte;
    }

    public LocalDate getDeuda_vencimiento() {
        return deuda_vencimiento;
    }

    public void setDeuda_vencimiento(LocalDate deuda_vencimiento) {
        this.deuda_vencimiento = deuda_vencimiento;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}
