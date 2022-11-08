package ec.edu.ups.servicesconsume.entity.respone;

import java.time.LocalDate;

public class ResponseUserContract {

    private String dni;
    private String address;
    private LocalDate dateSuscription;


    public ResponseUserContract() { }

    public ResponseUserContract(String dni, String address, LocalDate dateSuscription) {
        this.dni = dni;
        this.address = address;
        this.dateSuscription = dateSuscription;
    }


    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public LocalDate getDateSuscription() { return dateSuscription; }
    public void setDateSuscription(LocalDate dateSuscription) { this.dateSuscription = dateSuscription; }


}