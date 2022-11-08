package ec.edu.ups.waterservice.entity.request;

import java.time.LocalDate;

public class ServiceWaterDTO {
    private long id;
    private String cedula;
    private Long contrato;
    private String nombre;
    private Double valorTotal;
    private Double valorMinimo;
    private LocalDate fechaEmision;
    private LocalDate fechaCorte;
    private LocalDate fechaMaxPago;
    private String observacion;
    private Boolean tieneMora;
    private Double montoMora;
    private Boolean tieneIntereses;
    private Double montoIntereses;

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getCedula() { return cedula;}
    public void setCedula(String cedula) { this.cedula = cedula;}

    public Long getContrato() { return contrato; }
    public void setContrato(Long contrato) { this.contrato = contrato; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Double getValorTotal() { return valorTotal; }
    public void setValorTotal(Double valorTotal) { this.valorTotal = valorTotal; }

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

    public Boolean getTieneMora() { return tieneMora; }
    public void setTieneMora(Boolean tieneMora) { this.tieneMora = tieneMora; }

    public Double getMontoMora() { return montoMora; }
    public void setMontoMora(Double montoMora) { this.montoMora = montoMora; }

    public Boolean getTieneIntereses() { return tieneIntereses; }
    public void setTieneIntereses(Boolean tieneIntereses) { this.tieneIntereses = tieneIntereses; }

    public Double getMontoIntereses() { return montoIntereses; }
    public void setMontoIntereses(Double montoIntereses) { this.montoIntereses = montoIntereses; }
}
