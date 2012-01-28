package com.simplecash.object;

import javax.persistence.*;

/**
 * A blob of information about a contact, for example email, telephone, etc.
 */
@Entity
public class ContactInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String type;
    private String value;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_contactInfoType")
    private ContactInfoType contactInfoType;

    public long getId() {
        return id;
    }

    /**
     * Get the type of contact info (Home, Work, etc.)
     */
    public String getType() {
        return type;
    }

    /**
     * Set the type of contact info (Home, Work, etc.)
     */
    public ContactInfo setType(String type) {
        this.type = type;
        return this;
    }

    public ContactInfoType.Type getContactInfoType() {
        return contactInfoType.getType();
    }

    public ContactInfo setContactInfoType(ContactInfoType.Type contactInfoType) {
        this.contactInfoType = new ContactInfoType(contactInfoType);
        return this;
    }

    public String getValue() {
        return value;
    }

    public ContactInfo setValue(String value) {
        this.value = value;
        return this;
    }
}
