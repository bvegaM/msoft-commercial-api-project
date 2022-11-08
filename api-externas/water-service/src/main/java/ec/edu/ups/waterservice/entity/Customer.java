package ec.edu.ups.waterservice.entity;

import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Customer {
    @Id
    @SequenceGenerator(name = "seqCustomer", sequenceName = "seqCustomerId", initialValue = 1)
    @GeneratedValue(generator = "seqCustomer")
    private long id;

    @Nationalized
    private String cedula;

    @Nationalized
    private String nombre;

    private LocalDate fechaNacimiento;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Contract> contracts;

    public Customer() {}
    public Customer(long id, String cedula, String nombre, LocalDate fechaNacimiento) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }
    public Customer(String cedula, String nombre, LocalDate fechaNacimiento) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public LocalDate getBirthDate() { return fechaNacimiento; }
    public void setBirthDate(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public List<Contract> getContracts() { return contracts; }
    public void setContracts(List<Contract> contracts) { this.contracts = contracts; }
}
