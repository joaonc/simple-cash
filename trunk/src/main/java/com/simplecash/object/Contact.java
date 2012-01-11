package com.simplecash.object;

import javax.persistence.*;
import java.util.Date;

/**
 * Contact pojo.
 */
@Entity
public class Contact {

    @Id
    @GeneratedValue
    private long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    
    public Contact() {
        createDate = new Date();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
