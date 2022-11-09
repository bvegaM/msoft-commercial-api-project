package ec.edu.ups.servicesconsume.entity.respone;

import java.time.LocalDate;
import java.util.List;

public class ResponseUserPromotions {

    private String serviceCode;
    private String serviceName;
    private String title;
    private String detail;
    private String uri;
    private LocalDate start_date;
    private LocalDate end_date;
    private List<String> pictures;




    public ResponseUserPromotions() { }

    public ResponseUserPromotions(String title, String detail, String uri, LocalDate start_date, LocalDate end_date) {
        this.title = title;
        this.detail = detail;
        this.uri = uri;
        this.start_date = start_date;
        this.end_date = end_date;
    }


    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDetail() { return detail; }
    public void setDetail(String detail) { this.detail = detail; }

    public String getUri() { return uri; }
    public void setUri(String uri) { this.uri = uri; }

    public LocalDate getStart_date() { return start_date; }
    public void setStart_date(LocalDate start_date) { this.start_date = start_date; }

    public LocalDate getEnd_date() { return end_date; }
    public void setEnd_date(LocalDate end_date) { this.end_date = end_date; }

    public List<String> getPictures() { return pictures; }
    public void setPictures(List<String> pictures) { this.pictures = pictures; }

    public String getServiceCode() { return serviceCode; }
    public void setServiceCode(String serviceCode) { this.serviceCode = serviceCode; }

    public String getServiceName() { return serviceName; }
    public void setServiceName(String serviceName) { this.serviceName = serviceName; }


}
