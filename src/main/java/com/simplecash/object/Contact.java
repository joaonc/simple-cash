package com.simplecash.object;

import javax.persistence.*;
import java.util.Date;

/**
 * Contact pojo.
 */
@Entity
public class Contact {

    private long id;
    private Date createDate;
    
    public Contact() {
        createDate = new Date();
    }

    @Id
    @GeneratedValue(generator="increment")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
