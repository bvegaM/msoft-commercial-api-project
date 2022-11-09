package ec.edu.ups.servicesconsume.entity.dto;

import ec.edu.ups.servicesconsume.entity.respone.ResponseUserAmmount;

import java.time.LocalDate;

public class S0002_DirectvAmountDTO {

    private Long sdr_id;
    private String cli_dni;
    private String cli_contrato;
    private String cli_nombres;
    private Double deuda_total;
    private Double deuda_minimo;
    private LocalDate deuda_emision;
    private LocalDate deuda_corte;
    private LocalDate deuda_vencimiento;
    private String observacion;

    public S0002_DirectvAmountDTO() { }

    public S0002_DirectvAmountDTO(Long sdr_id, String cli_dni, String cli_contrato, String cli_nombres, Double deuda_total, Double deuda_minimo, LocalDate deuda_emision, LocalDate deuda_corte, LocalDate deuda_vencimiento, String observacion) {
        this.sdr_id = sdr_id;
        this.cli_dni = cli_dni;
        this.cli_contrato = cli_contrato;
        this.cli_nombres = cli_nombres;
        this.deuda_total = deuda_total;
        this.deuda_minimo = deuda_minimo;
        this.deuda_emision = deuda_emision;
        this.deuda_corte = deuda_corte;
        this.deuda_vencimiento = deuda_vencimiento;
        this.observacion = observacion;
    }


    public Long getSdr_id() { return sdr_id; }
    public void setSdr_id(Long sdr_id) { this.sdr_id = sdr_id; }

    public String getCli_dni() { return cli_dni; }
    public void setCli_dni(String cli_dni) { this.cli_dni = cli_dni; }

    public String getCli_contrato() { return cli_contrato; }
    public void setCli_contrato(String cli_contrato) { this.cli_contrato = cli_contrato; }

    public String getCli_nombres() { return cli_nombres; }
    public void setCli_nombres(String cli_nombres) { this.cli_nombres = cli_nombres; }

    public Double getDeuda_total() { return deuda_total; }
    public void setDeuda_total(Double deuda_total) { this.deuda_total = deuda_total; }

    public Double getDeuda_minimo() { return deuda_minimo; }
    public void setDeuda_minimo(Double deuda_minimo) { this.deuda_minimo = deuda_minimo; }

    public LocalDate getDeuda_emision() { return deuda_emision; }
    public void setDeuda_emision(LocalDate deuda_emision) { this.deuda_emision = deuda_emision; }

    public LocalDate getDeuda_corte() { return deuda_corte; }
    public void setDeuda_corte(LocalDate deuda_corte) { this.deuda_corte = deuda_corte; }

    public LocalDate getDeuda_vencimiento() { return deuda_vencimiento; }
    public void setDeuda_vencimiento(LocalDate deuda_vencimiento) { this.deuda_vencimiento = deuda_vencimiento; }

    public String getObservacion() { return observacion; }
    public void setObservacion(String observacion) { this.observacion = observacion; }

    public ResponseUserAmmount convertToResponseUser() {
        ResponseUserAmmount dto = new ResponseUserAmmount(this.cli_dni, this.cli_contrato, this.cli_nombres, this.deuda_total, this.deuda_minimo, this.deuda_total,
                this.deuda_emision, this.deuda_corte, this.deuda_vencimiento, this.observacion);
        return  dto;
    }


}
