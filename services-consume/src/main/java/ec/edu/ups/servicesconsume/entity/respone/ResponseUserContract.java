package ec.edu.ups.servicesconsume.entity.respone;

import java.time.LocalDate;

public class ResponseUserContract {

    private String serviceCode;
    private String serviceName;
    private String dni;
    private String address;
    private LocalDate dateSubscription;



    public ResponseUserContract() { }

    public ResponseUserContract(String dni, String address, LocalDate dateSuscription) {
        this.dni = dni;
        this.address = address;
        this.dateSubscription = dateSuscription;
    }


    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public LocalDate getDateSubscription() { return dateSubscription; }
    public void setDateSubscription(LocalDate dateSubscription) { this.dateSubscription = dateSubscription; }

    public String getServiceCode() { return serviceCode; }
    public void setServiceCode(String serviceCode) { this.serviceCode = serviceCode; }

    public String getServiceName() { return serviceName; }
    public void setServiceName(String serviceName) { this.serviceName = serviceName; }


}
