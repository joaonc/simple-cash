package com.simplecash.object;

import javax.persistence.*;

/**
 * Customer that can be an individual or a company.
 */
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_contact")
    Contact contact;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}