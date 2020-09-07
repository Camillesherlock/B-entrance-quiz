package com.thoughtworks.capability.gtb.entrancequiz.domain;

public class groupMembers {
    private int id;
    private String name;

    public void groupMembers(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
