package Entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Address {
    @Id
    @Column(name = "address_ID")
    @GeneratedValue(generator = "incrementator")
    @GenericGenerator(name = "incrementator", strategy = "increment")
    private int id;

    private String country;
    private String city;
    private String street;
    private String home_number;
    private String flat_number;



    @OneToOne(cascade = CascadeType.ALL, mappedBy = "address")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Address(){
    }

    public Address(String country, String city, String street, String home_number, String flat_number) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.home_number = home_number;
        this.flat_number = flat_number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHome_number() {
        return home_number;
    }

    public void setHome_number(String home_number) {
        this.home_number = home_number;
    }

    public String getFlat_number() {
        return flat_number;
    }

    public void setFlat_number(String flat_number) {
        this.flat_number = flat_number;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", home_number='" + home_number + '\'' +
                ", flat_number='" + flat_number +
                '}';
    }
}
