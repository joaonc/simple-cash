package com.simplecash.object;

import javax.persistence.*;

/**
 * Type of contact information (email, telephone, etc.)
 */
@Entity
public class ContactInfoType {

    // Following the solution proposed here for enum persistence
    // http://stackoverflow.com/questions/2751733/map-enum-in-jpa-with-fixed-values
    // http://duydo.com/effective-jpa-persist-an-enumerationeffectively

    public enum Type {

        Email(1),
        Telephone(2),
        Note(3);
        
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

        public static Type parse(int id) {
            Type type = null;  // Default
            for (Type item : Type.values()) {
                if (item.getId() == id) {
                    type = item;
                    break;
                }
            }

            return type;
        }
    };

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private int id_type;
    private String name;  // So it can be visible in the database
    private String description;

    public Type getType() {
        return Type.parse(id_type);
    }

    public void setType(Type type) {
        id_type = type.getId();
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
