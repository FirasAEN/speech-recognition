package com.capco.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by Firas on 8/5/2018.
 */
public class Major {
    @JsonIgnore
    private long id;
    private String name;

    public Major(String majorName){
        this.name = majorName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Major{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
