package com.simplecash.object;

import javax.persistence.*;
import java.util.Date;

/**
 * Contains information about the database, especially the schema.
 * This allows for the client to check compatibility with the database.
 */
@Entity
public class DbInfo implements Comparable<DbInfo> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int major;
    private int minor;
    private Date dateImplemented;
    private String comments;

    public DbInfo () {
        dateImplemented = new Date();
    }
    
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

    public Date getDateImplemented() {
        return dateImplemented;
    }

    public void setDateImplemented(Date dateImplemented) {
        this.dateImplemented = dateImplemented;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * Checks if the versions are the same.
     *
     * @param dbInfo    the reference object with which to compare the version.
     * @return  <code>true</code> if this object has the same version as the dbInfo
     *          argument; <code>false</code> otherwise.
     *          <br>Note that id, date and comments are ignored in the comparison.
     */
    public boolean hasSameVersion(DbInfo dbInfo) {
        return
                (major == dbInfo.major) &&
                (minor == dbInfo.minor);
    }

    /**
     * Compares versions.
     * <br>Note that id, dateImplemented and comments are ignored in the comparison.
     *
     * @param dbInfo    the reference object with which to compare the version.
     * @return  a negative integer, zero, or a positive integer as this object
     *		    is less than, equal to, or greater than the specified object.
     */
    @Override
    public int compareTo(DbInfo dbInfo) {
        if (major < dbInfo.major) return -1;
        else if (major > dbInfo.major ) return 1;
        else if (minor < dbInfo.minor) return -1;
        else if (minor > dbInfo.minor) return 1;

        return 0;
    }

    @Override
    public String toString() {
        return String.format("%s.%s", major, minor);
    }
}
