package entities;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@NamedQueries({
        @NamedQuery(name = "Address.deleteAllRows", query = "DELETE from Address"),
        @NamedQuery(name = "Address.getAll", query = "SELECT a FROM Address a"),
})
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id", nullable = false)
    private int id;

    @Column(name = "address", nullable = false, length = 45)
    private String address;

    @Column(name = "additionalInfo", length = 45)
    private String additionalInfo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cityinfo_id", nullable = false)
    private Cityinfo cityinfo;

    @OneToMany(mappedBy = "address")
    private Set<Person> people = new LinkedHashSet<>();

    public int getId() {
        return id;
    }

    public Address() {
    }

    public Address(String address, String additionalInfo) {
        this.address = address;
        this.additionalInfo = additionalInfo;
    }

    public Address(String address, String additionalInfo, Cityinfo cityinfo) {
        this.address = address;
        this.additionalInfo = additionalInfo;
        this.cityinfo = cityinfo;
    }

    public Address(String address, String additionalInfo, Cityinfo cityinfo, Set<Person> people) {
        this.address = address;
        this.additionalInfo = additionalInfo;
        this.cityinfo = cityinfo;
        this.people = people;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public Cityinfo getCityinfo() {
        return cityinfo;
    }

    public void setCityinfo(Cityinfo cityinfo) {
        this.cityinfo = cityinfo;
    }

    public Set<Person> getPeople() {
        return people;
    }

    public void setPeople(Set<Person> people) {
        this.people = people;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", additionalInfo='" + additionalInfo + '\'' +
                ", cityinfo=" + cityinfo +
                ", people=" + people +
                '}';
    }
}