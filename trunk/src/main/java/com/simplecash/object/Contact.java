package com.simplecash.object;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Contact information for other entities such as Supplier and Customer.
 * A contact is composed of zero or more ContactInfo and zero or more Address instances, ie,
 * one contact can have 1 email and 2 phones, another 3 emails 2 addresses and 1 phone.
 */
@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(
            name = "Contact_ContactInfo",
            joinColumns = { @JoinColumn(name = "id_contact") },
            inverseJoinColumns = { @JoinColumn(name = "id_contactInfo") })
    private Set<ContactInfo> contactInfos;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(
            name = "Contact_Address",
            joinColumns = { @JoinColumn(name = "id_contact") },
            inverseJoinColumns = { @JoinColumn(name = "id_address") })
    private Set<Address> addresses;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ContactInfo> getContactInfos() {
        return contactInfos;
    }

    public Contact setContactInfos(Set<ContactInfo> contactInfos) {
        this.contactInfos = contactInfos;
        return this;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public Contact setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
        return this;
    }

    /**
     * Adds a blob of contact information.
     *
     * @param contactInfo    The contact information. Does nothing if <code>null</code>.
     * @return The contact.
     */
    public Contact addContactInfo(ContactInfo contactInfo) {
        if (contactInfo != null) {
            if (contactInfos == null) {
                contactInfos = new LinkedHashSet<ContactInfo>();
            }
            contactInfos.add(contactInfo);
        }

        return this;
    }

    /**
     * Adds an address.
     *
     * @param address    The address. Does nothing if <code>null</code>.
     * @return The contact.
     */
    public Contact addAddress(Address address) {
        if (address != null) {
            if (addresses == null) {
                addresses = new LinkedHashSet<Address>();
            }
            addresses.add(address);
        }

        return this;
    }
}
