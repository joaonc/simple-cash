package com.simplecash.object;

import javax.persistence.*;

/**
 * Contains information about the database, especially the schema.
 * This allows for the client to check compatibility with the database.
 */
@Entity
public class DbInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int major;
    private int minor;
    private String comments;

    public long getId() {
        return id;
    }

    public int getMajor() {
        return major;
    }

    public void setMajor(int major) {
        this.major = major;
    }

    public int getMinor() {
        return minor;
    }

    public void setMinor(int minor) {
        this.minor = minor;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
