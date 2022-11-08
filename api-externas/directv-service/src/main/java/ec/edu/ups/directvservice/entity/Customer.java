package ec.edu.ups.directvservice.entity;

import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Customer {
    @Id
    @SequenceGenerator(name = "seqCustomer", sequenceName = "seqCustomerId", initialValue = 1)
    @GeneratedValue(generator = "seqCustomer")
    private long cli_id;

    @Nationalized
    private String cli_cedula;

    @Nationalized
    private String cli_nombre;

    private LocalDate cli_fechaNacimiento;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Contract> contracts;

    public Customer() {}
    public Customer(long cli_id, String cli_cedula, String cli_nombre, LocalDate cli_fechaNacimiento) {
        this.cli_id = cli_id;
        this.cli_cedula = cli_cedula;
        this.cli_nombre = cli_nombre;
        this.cli_fechaNacimiento = cli_fechaNacimiento;
    }
    public Customer(String cli_cedula, String cli_nombre, LocalDate cli_fechaNacimiento) {
        this.cli_cedula = cli_cedula;
        this.cli_nombre = cli_nombre;
        this.cli_fechaNacimiento = cli_fechaNacimiento;
    }

    public long getCli_id() {
        return cli_id;
    }

    public void setCli_id(long cli_id) {
        this.cli_id = cli_id;
    }

    public String getCli_cedula() {
        return cli_cedula;
    }

    public void setCli_cedula(String cli_cedula) {
        this.cli_cedula = cli_cedula;
    }

    public String getCli_nombre() {
        return cli_nombre;
    }

    public void setCli_nombre(String cli_nombre) {
        this.cli_nombre = cli_nombre;
    }

    public LocalDate getCli_fechaNacimiento() {
        return cli_fechaNacimiento;
    }

    public void setCli_fechaNacimiento(LocalDate cli_fechaNacimiento) {
        this.cli_fechaNacimiento = cli_fechaNacimiento;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}
