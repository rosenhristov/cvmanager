package com.scalefocus.cvmanager.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Address {

    @Id
    @GeneratedValue
    private int id;
    private int postalCode;
    private String city;
    private String street;
    private int streetNumber;
    private String country;

    public Address() {
    }

    @Autowired
    public Address(String country, int postalCode, String city, String street, int streetNumber) {
        this.country = country;
        this.postalCode = postalCode;
        this.city = city;
        this.street = street;
        this.streetNumber = streetNumber;
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

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
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

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetAddress() {
        return streetNumber + " " + street;
    }

    public void setStreetAddress(String street, int streetNumber) {
        this.street = street;
        this.streetNumber = streetNumber;
    }

    public String print() {
        return new StringBuilder(postalCode).append(' ').append(city).append(",\n")
                    .append(streetNumber).append(" ").append(street).append("\n")
                    .append(country)
                    .toString();
    }

    @Override
    public String toString() {
        return "Adress{" +
                "country='" + country + '\'' +
                ", postalCode=" + postalCode +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", streetNumber=" + streetNumber +
                '}';
    }
}
