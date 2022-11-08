package ec.edu.ups.servicesconsume.entity.request;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RequestService {

    private String dni;
    private String contract;


    public RequestService() { }

    public RequestService(String dni, String contract) {
        this.dni = dni;
        this.contract = contract;
    }


    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getContract() { return contract; }
    public void setContract(String contract) { this.contract = contract; }


    public String getStringReplace(String uri) {
        LocalDate today = LocalDate.now();
        String formattedDate = today.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        return uri
                .replace("{{dni}}", this.dni)
                .replace("{{contract}}", this.contract)
                .replace("{{date}}", formattedDate)
            ;
    }


}
