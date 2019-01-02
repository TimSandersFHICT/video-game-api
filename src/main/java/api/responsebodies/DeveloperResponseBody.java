package api.responsebodies;

import java.sql.Date;

public class DeveloperResponseBody {

    private Long id;
    private String name;
    private String address;
    private int numEmployees;
    private Date dateFounded;

    public DeveloperResponseBody(Long id, String name, String address, int numEmployees, Date dateFounded) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.numEmployees = numEmployees;
        this.dateFounded = dateFounded;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumEmployees() {
        return numEmployees;
    }

    public void setNumEmployees(int numEmployees) {
        this.numEmployees = numEmployees;
    }

    public Date getDateFounded() {
        return dateFounded;
    }

    public void setDateFounded(Date dateFounded) {
        this.dateFounded = dateFounded;
    }
}
