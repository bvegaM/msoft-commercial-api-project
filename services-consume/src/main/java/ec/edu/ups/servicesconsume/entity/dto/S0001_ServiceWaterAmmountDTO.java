package ec.edu.ups.servicesconsume.entity.dto;

import ec.edu.ups.servicesconsume.entity.respone.ResponseUserAmmount;

import java.time.LocalDate;

public class S0001_ServiceWaterAmmountDTO {

    private Long id;
    private String cedula;
    private String contrato;
    private String nombre;
    private Double valorTotal;
    private Double valorMinimo;
    private LocalDate fechaEmision;
    private LocalDate fechaCorte;
    private LocalDate fechaMaxPago;
    private String observacion;
    private boolean tieneMora;
    private Double montoMora;
    private boolean tieneIntereses;
    private Double montoIntereses;

    public S0001_ServiceWaterAmmountDTO() { }

    public S0001_ServiceWaterAmmountDTO(Long id, String cedula, String contrato, String nombre, Double valorTotal, Double valorMinimo, LocalDate fechaEmision, LocalDate fechaCorte, LocalDate fechaMaxPago, String observacion, boolean tieneMora, Double montoMora, boolean tieneIntereses, Double montoIntereses) {
        this.id = id;
        this.cedula = cedula;
        this.contrato = contrato;
        this.nombre = nombre;
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


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }

    public String getContrato() { return contrato; }
    public void setContrato(String contrato) { this.contrato = contrato; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Double getValorMinimo() { return valorMinimo; }
    public void setValorMinimo(Double valorMinimo) { this.valorMinimo = valorMinimo; }

    public LocalDate getFechaEmision() { return fechaEmision; }
    public void setFechaEmision(LocalDate fechaEmision) { this.fechaEmision = fechaEmision; }

    public LocalDate getFechaCorte() { return fechaCorte; }
    public void setFechaCorte(LocalDate fechaCorte) { this.fechaCorte = fechaCorte; }

    public LocalDate getFechaMaxPago() { return fechaMaxPago; }
    public void setFechaMaxPago(LocalDate fechaMaxPago) { this.fechaMaxPago = fechaMaxPago; }

    public String getObservacion() { return observacion; }
    public void setObservacion(String observacion) { this.observacion = observacion; }

    public boolean isTieneMora() { return tieneMora; }
    public void setTieneMora(boolean tieneMora) { this.tieneMora = tieneMora; }

    public Double getMontoMora() { return montoMora; }
    public void setMontoMora(Double montoMora) { this.montoMora = montoMora; }

    public boolean isTieneIntereses() { return tieneIntereses; }
    public void setTieneIntereses(boolean tieneIntereses) { this.tieneIntereses = tieneIntereses; }

    public Double getMontoIntereses() { return montoIntereses; }
    public void setMontoIntereses(Double montoIntereses) { this.montoIntereses = montoIntereses; }

    public Double getValorTotal() { return valorTotal; }
    public void setValorTotal(Double valorTotal) { this.valorTotal = valorTotal; }


    public ResponseUserAmmount convertoToResponseUser() {
        ResponseUserAmmount dto = new ResponseUserAmmount(this.cedula, this.contrato, this.nombre, this.valorTotal, this.valorMinimo, this.valorTotal,
                this.fechaEmision, this.fechaCorte, this.fechaMaxPago, this.observacion);
        return  dto;
    }




}
