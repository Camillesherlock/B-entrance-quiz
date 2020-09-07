package com.thoughtworks.capability.gtb.entrancequiz.service;

import com.thoughtworks.capability.gtb.entrancequiz.domain.Members;

import java.util.ArrayList;
import java.util.List;


public class MembersService {
    private List<Members> allMembers = initAllMembers();

    public List<Members> initAllMembers() {
        List<Members> members = new ArrayList<>();
        return members;
    }

    public List<Members> getAllMembers(){
        return allMembers;
    }

    public void addMembers(String name){
        Members member = new Members();
        member.Members(2,name);
    }

}
