package com.simplecash.object;

import javax.persistence.*;

/**
 * Type of contact information (email, telephone, etc.)
 */
@Entity
public class ContactInfoType {

    // Following the solution proposed in the links below for enum persistence
    // http://stackoverflow.com/questions/2751733/map-enum-in-jpa-with-fixed-values
    // http://duydo.com/effective-jpa-persist-an-enumerationeffectively

    public enum Type {

        Email(1),
        Telephone(2),
        Url(3),
        Note(4);
        
        private int id;
        private String description;

        Type(int value) {
            this.id = value;
        }

        Type(int value, String description) {
            this.id = value;
            this.description = description;
        }
        
        public int getId() {
            return id;
        }

        public String getDescription() {
            return description;
        }

        public static Type getById(int id) {
            Type type = null;  // Default
            for (Type item : Type.values()) {
                if (item.getId() == id) {
                    type = item;
                    break;
                }
            }

            return type;
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     * The id defined in the enum, ie, <code>ContactInfoType.Type.getId()</code>.
     */
    @Basic(optional = false)
    @Column(unique = true, nullable = false)
    private int idType;

    @Basic(optional = false)
    @Column(unique = true, nullable = false)
    private String name;  // So it can be visible in the database

    private String description;  // So it can be visible in the database

    public ContactInfoType() {
    }

    public ContactInfoType(Type type) {
        setType(type);
    }

    public Type getType() {
        return Type.getById(idType);
    }

    public void setType(Type type) {
        idType = type.getId();
        name = type.toString();
        description = type.getDescription();
    }
    
    public String getName() {
        return name;
    }
    
    public String getDescription() {
        return description;
    }
}
