package com.simplecash.object;

import com.simplecash.object.constant.TagType;

import javax.persistence.*;

/**
 * The type of Supplier with name and description.
 * A Supplier can have 0 or more types. Acts similarly to a tag.
 * Ex "Tom's Hardware Shop" can have the type "Motor repair" and ""
 */
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    TagType tagType;
    private String name;
    private String description;

    public long getId() {
        return id;
    }

    public TagType getTagType() {
        return tagType;
    }

    public void setTagType(TagType tagType) {
        this.tagType = tagType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
