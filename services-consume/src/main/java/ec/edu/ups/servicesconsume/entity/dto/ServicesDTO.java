package ec.edu.ups.servicesconsume.entity.dto;

import java.time.LocalDate;

public class ServicesDTO {

    private String code;
    private String name;
    private String status;
    private LocalDate dateStarting;
    private LocalDate dateStopping;
    private String detail;

    public ServicesDTO() { }

    public ServicesDTO(String code, String name, String status, LocalDate dateStarting, LocalDate dateStopping, String detail) {
        this.code = code;
        this.name = name;
        this.status = status;
        this.dateStarting = dateStarting;
        this.dateStopping = dateStopping;
        this.detail = detail;
    }


    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDate getDateStarting() { return dateStarting; }
    public void setDateStarting(LocalDate dateStarting) { this.dateStarting = dateStarting; }

    public LocalDate getDateStopping() { return dateStopping; }
    public void setDateStopping(LocalDate dateStopping) { this.dateStopping = dateStopping; }

    public String getDetail() { return detail; }
    public void setDetail(String detail) { this.detail = detail; }

}
