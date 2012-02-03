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

    /**
     * ContactInfoType.Type.id
     * Note that this is not an ID in the database, but rather the value set in the enum definition.
     */
    private int id_contactInfoType;

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
        return ContactInfoType.Type.getById(id_contactInfoType);
    }

    public ContactInfo setContactInfoType(ContactInfoType.Type contactInfoType) {
        id_contactInfoType = contactInfoType.getId();
        return this;
    }

    public String getValue() {
        return value;
    }

    public ContactInfo setValue(String value) {
        this.value = value;
        return this;
    }

    @Override
    public String toString() {
        return String.format("Type: %s, TypeDescription: %s, Value: %s",
                getContactInfoType().toString(), type, value);
    }
}
