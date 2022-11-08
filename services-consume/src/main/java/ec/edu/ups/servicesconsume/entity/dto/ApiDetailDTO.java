package ec.edu.ups.servicesconsume.entity.dto;

import ec.edu.ups.servicesconsume.entity.ApiDetail;
import ec.edu.ups.servicesconsume.entity.ServicePartner;
import ec.edu.ups.servicesconsume.enums.ApiMethod;
import ec.edu.ups.servicesconsume.enums.ApiType;

import javax.persistence.*;

public class ApiDetailDTO {

    private Long id;
    private ApiType type;
    private ApiMethod method;
    private String uri;
    private String body;

    public ApiDetailDTO() { }

    public ApiDetailDTO(Long id, ApiType type, ApiMethod method, String uri, String body) {
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

    public ApiMethod getMethod() { return method; }
    public void setMethod(ApiMethod method) { this.method = method; }

    public String getUri() { return uri; }
    public void setUri(String uri) { this.uri = uri; }

    public String getBody() { return body; }
    public void setBody(String body) { this.body = body; }

    public ApiDetail convertEntity() {
        ApiDetail apiDetail = new ApiDetail(this.id, this.type, this.method, this.uri, this.body);
        return apiDetail;
    }

}
