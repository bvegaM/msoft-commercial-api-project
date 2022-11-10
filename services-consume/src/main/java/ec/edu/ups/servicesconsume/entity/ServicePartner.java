package ec.edu.ups.servicesconsume.entity;

import ec.edu.ups.servicesconsume.entity.dto.ServicePartnerDTO;
import ec.edu.ups.servicesconsume.entity.dto.ServicesDTO;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "service_partner")
public class ServicePartner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;
    private String name;
    private String status;
    private LocalDate dateStarting;
    private LocalDate dateStopping;
    private String detail;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "servicePartner", cascade = CascadeType.ALL)
    private List<ApiDetail> apiDetails;


    public ServicePartner() { }

    public ServicePartner(Long id, String code, String name, String status, LocalDate dateStarting, LocalDate dateStopping, String detail) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.status = status;
        this.dateStarting = dateStarting;
        this.dateStopping = dateStopping;
        this.detail = detail;
    }

    public ServicePartner(String code, String name, String status, LocalDate dateStarting, LocalDate dateStopping, String detail) {
        this.code = code;
        this.name = name;
        this.status = status;
        this.dateStarting = dateStarting;
        this.dateStopping = dateStopping;
        this.detail = detail;
    }

    public ServicePartner(Long id, String code, String name, String status, LocalDate dateStarting, LocalDate dateStopping, String detail, List<ApiDetail> apiDetails) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.status = status;
        this.dateStarting = dateStarting;
        this.dateStopping = dateStopping;
        this.detail = detail;
        this.apiDetails = apiDetails;
    }


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDate getDateStarting() { return dateStarting; }
    public void setDateStarting(LocalDate dateStarting) { this.dateStarting = dateStarting;}

    public LocalDate getDateStopping() { return dateStopping; }
    public void setDateStopping(LocalDate dateStopping) { this.dateStopping = dateStopping; }

    public String getDetail() { return detail; }
    public void setDetail(String detail) { this.detail = detail; }

    public List<ApiDetail> getApiDetails() { return apiDetails; }
    public void setApiDetails(List<ApiDetail> apiDetails) { this.apiDetails = apiDetails; }


    public ServicePartnerDTO convertDTO() {
        ServicePartnerDTO dto = new ServicePartnerDTO(this.code, this.name, this.status, this.dateStarting, this.dateStopping, this.detail);
        if(this.apiDetails != null) {
            dto.setApiDetails( this.apiDetails.stream().map(ApiDetail::convertDTO).collect(Collectors.toList()) );
        }
        return dto;
    }

    public ServicesDTO convertServiceDTO() {
        ServicesDTO dto = new ServicesDTO(this.code, this.name, this.status, this.dateStarting, this.dateStopping, this.detail);
        return dto;
    }

}
