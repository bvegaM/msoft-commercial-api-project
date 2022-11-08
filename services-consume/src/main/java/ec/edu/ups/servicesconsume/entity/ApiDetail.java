package ec.edu.ups.servicesconsume.entity;

import ec.edu.ups.servicesconsume.entity.dto.ApiDetailDTO;
import ec.edu.ups.servicesconsume.enums.ApiMethod;
import ec.edu.ups.servicesconsume.enums.ApiType;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import javax.persistence.*;

@Entity
@Table(name = "api_detail")
public class ApiDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ApiType type;

    @Enumerated(EnumType.STRING)
    private ApiMethod method;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ServicePartner.class)
    @JoinColumn(name = "partnerId", referencedColumnName = "id")
    private ServicePartner servicePartner;

    private String uri;

    private String body;


    public ApiDetail() { }

    public ApiDetail(Long id, ApiType type, ApiMethod method, String uri, String body) {
        this.id = id;
        this.type = type;
        this.method = method;
        this.uri = uri;
        this.body = body;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public ApiType getType() { return type; }
    public void setType(ApiType type) { this.type = type; }

    public ServicePartner getServicePartner() { return servicePartner; }
    public void setServicePartner(ServicePartner servicePartner) { this.servicePartner = servicePartner; }

    public String getUri() { return uri; }
    public void setUri(String uri) { this.uri = uri; }

    public ApiMethod getMethod() { return method; }
    public void setMethod(ApiMethod method) { this.method = method; }

    public String getBody() { return body; }
    public void setBody(String body) { this.body = body; }


    public ApiDetailDTO convertDTO() {
        ApiDetailDTO dto = new ApiDetailDTO(this.id, this.type, this.method, this.uri, this.body);
        return dto;
    }


    public HttpEntity getHTTPBody() {
        HttpHeaders headers = new HttpHeaders(); headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<String>(this.body, headers);
        return  request;
    }


}
