package com.thoughtworks.capability.gtb.entrancequiz.service;

import com.thoughtworks.capability.gtb.entrancequiz.domain.Members;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MembersService {
    private List<Members> allMembers = initAllMembers();
    private int index = 1;

    public List<Members> initAllMembers() {
        Members member = new Members();
        member.Members(1,"廖浚斌");
        List<Members> members = new ArrayList<>();
        members.add(member);
        return members;
    }

    public List<Members> getAllMembers(){
        return allMembers;
    }

    public void addMembers(String name){
        index++;
        Members member = new Members();
        member.Members(index,name);
        allMembers.add(member);
    }

}
