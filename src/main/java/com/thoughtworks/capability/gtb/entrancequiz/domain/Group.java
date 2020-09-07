package com.thoughtworks.capability.gtb.entrancequiz.domain;

import java.util.List;

public class Group {
    private String groupName;
    List<Members> students;

    public Group(String groupName, List<Members> students){
        this.groupName = groupName;
        this.students = students;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Members> getStudents() {
        return students;
    }

    public void setStudents(List<Members> students) {
        this.students = students;
    }
}
