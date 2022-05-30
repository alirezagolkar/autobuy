package com.dealers.autobuy.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

/**
 * Entity for dealer
 * @author Ali Golkar
 */
@Entity
public class Dealer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Column(length = 100)
    private String name;

    @NotNull
    @Column(length = 30)
    private String phoneNumber;

    @NotNull
    @Column(length = 100)
    private String emailAddress;

    @NotNull
    @Column(length = 200)
    private String address;

    @JsonIgnore
    @OneToMany(mappedBy = "dealer", fetch = FetchType.LAZY)
    private List<Vehicle> vehicles;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dealer dealer = (Dealer) o;
        return Objects.equals(id, dealer.id) && Objects.equals(name, dealer.name) && Objects.equals(phoneNumber, dealer.phoneNumber) && Objects.equals(emailAddress, dealer.emailAddress) && Objects.equals(address, dealer.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phoneNumber, emailAddress, address);
    }
}
