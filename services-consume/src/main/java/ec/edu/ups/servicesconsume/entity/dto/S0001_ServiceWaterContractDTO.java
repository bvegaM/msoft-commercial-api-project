package ec.edu.ups.servicesconsume.entity.dto;

import ec.edu.ups.servicesconsume.entity.respone.ResponseUserContract;

import java.time.LocalDate;

public class S0001_ServiceWaterContractDTO {
    private Long id;
    private String clienteId;
    private String direccionDomicilio;
    private LocalDate fecha;

    public S0001_ServiceWaterContractDTO() { }

    public S0001_ServiceWaterContractDTO(Long id, String clienteId, String direccionDomicilio, LocalDate fecha) {
        this.id = id;
        this.clienteId = clienteId;
        this.direccionDomicilio = direccionDomicilio;
        this.fecha = fecha;
    }


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getClienteId() { return clienteId; }
    public void setClienteId(String clienteId) { this.clienteId = clienteId; }

    public String getDireccionDomicilio() { return direccionDomicilio; }
    public void setDireccionDomicilio(String direccionDomicilio) { this.direccionDomicilio = direccionDomicilio; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }


    public ResponseUserContract convertToResponseUser() {
        ResponseUserContract dto = new ResponseUserContract(this.clienteId, this.direccionDomicilio, this.fecha);
        return dto;
    }

}
