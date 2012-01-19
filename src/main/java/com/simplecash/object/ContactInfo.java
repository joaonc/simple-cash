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
    @Enumerated(EnumType.STRING)
    private ContactInfoType.Type contactInfoType;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ContactInfoType.Type getContactInfoType() {
        return contactInfoType;
    }

    public void setContactInfoType(ContactInfoType.Type contactInfoType) {
        this.contactInfoType = contactInfoType;
    }
}
