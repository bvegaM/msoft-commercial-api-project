package ec.edu.ups.servicesconsume.entity.respone;

import java.time.LocalDate;

public class ResponseUserAmount {


    private String serviceCode;
    private String serviceName;
    private String dni;
    private String contractNumber;
    private String customer;
    private Double ammount;
    private Double ammountMin;
    private Double ammountMax;
    private LocalDate issueDate;
    private LocalDate cutdate;
    private LocalDate duedate;
    private String remarks;


    public ResponseUserAmount() { }

    public ResponseUserAmount(String dni, String contractNumber, String customer, Double ammount, Double ammountMin, Double ammountMax, LocalDate issueDate, LocalDate cutdate, LocalDate duedate, String remarks) {
        this.dni = dni;
        this.contractNumber = contractNumber;
        this.customer = customer;
        this.ammount = ammount;
        this.ammountMin = ammountMin;
        this.ammountMax = ammountMax;
        this.cutdate = cutdate;
        this.duedate = duedate;
        this.remarks = remarks;
        this.issueDate = issueDate;
    }


    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getContractNumber() { return contractNumber; }
    public void setContractNumber(String contractNumber) { this.contractNumber = contractNumber; }

    public String getCustomer() { return customer; }
    public void setCustomer(String customer) { this.customer = customer; }

    public Double getAmmount() { return ammount; }
    public void setAmmount(Double ammount) { this.ammount = ammount; }

    public Double getAmmountMin() { return ammountMin; }
    public void setAmmountMin(Double ammountMin) { this.ammountMin = ammountMin; }

    public Double getAmmountMax() { return ammountMax; }
    public void setAmmountMax(Double ammountMax) { this.ammountMax = ammountMax; }

    public LocalDate getCutdate() { return cutdate; }
    public void setCutdate(LocalDate cutdate) { this.cutdate = cutdate; }

    public LocalDate getDuedate() { return duedate; }
    public void setDuedate(LocalDate duedate) { this.duedate = duedate; }

    public String getRemarks() { return remarks; }
    public void setRemarks(String remarks) { this.remarks = remarks; }

    public LocalDate getIssueDate() { return issueDate; }
    public void setIssueDate(LocalDate issueDate) { this.issueDate = issueDate; }

    public String getServiceCode() { return serviceCode; }
    public void setServiceCode(String serviceCode) { this.serviceCode = serviceCode; }

    public String getServiceName() { return serviceName; }
    public void setServiceName(String serviceName) { this.serviceName = serviceName; }



}
