package com.simplecash.object;

import javax.persistence.*;

/**
 *
 */
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     * Name of the address, ex "Home" or "Work"
     */
    private String name;
    /**
     * Complementary information about the address.
     */
    private String notes;

    private String address1;
    private String address2;
    private String postalCode;
    private String county;
    private String state;
    private String region;
    private String country;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Address setName(String name) {
        this.name = name;
        return this;
    }

    public String getNotes() {
        return notes;
    }

    public Address setNotes(String notes) {
        this.notes = notes;
        return this;
    }

    public String getAddress1() {
        return address1;
    }

    public Address setAddress1(String address1) {
        this.address1 = address1;
        return this;
    }

    public String getAddress2() {
        return address2;
    }

    public Address setAddress2(String address2) {
        this.address2 = address2;
        return this;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public Address setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public String getCounty() {
        return county;
    }

    public Address setCounty(String county) {
        this.county = county;
        return this;
    }

    public String getState() {
        return state;
    }

    public Address setState(String state) {
        this.state = state;
        return this;
    }

    public String getRegion() {
        return region;
    }

    public Address setRegion(String region) {
        this.region = region;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public Address setCountry(String country) {
        this.country = country;
        return this;
    }

    @Override
    public String toString() {
        return String.format(
                "Name: %s\nAddress 1: %s\nAddress 2: %s\nPostal Code: %s\nState: %s" +
                "Region: %s\nCountry: %s\nNotes: %s",
                name, address1, address2, postalCode, state, region, country, notes);
    }
}
