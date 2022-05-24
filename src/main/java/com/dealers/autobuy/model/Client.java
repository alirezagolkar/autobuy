package com.dealers.autobuy.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.sun.istack.NotNull;

/**
 * Entity for client
 * @author Ali Golkar
 */
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Column(length = 100)
    private String firstName;

    @NotNull
    @Column(length = 100)
    private String lastName;

    @NotNull
    @Column(length = 30)
    private String phoneNumber;

    @NotNull
    @Column(length = 100)
    private String emailAddress;

    @NotNull
    @Column(length = 200)
    private String address;

    @OneToMany(
            mappedBy = "client",
            cascade = {
                    CascadeType.ALL,
            },
            orphanRemoval = true
    )
    private List<ClientVehicle> clientVehicles = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<ClientVehicle> getClientVehicles() {
        return clientVehicles;
    }

    public void setClientVehicles(List<ClientVehicle> clientVehicles) {
        this.clientVehicles = clientVehicles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) &&
                Objects.equals(firstName, client.firstName) &&
                Objects.equals(lastName, client.lastName) &&
                Objects.equals(phoneNumber, client.phoneNumber) &&
                Objects.equals(emailAddress, client.emailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, phoneNumber, emailAddress);
    }
}
