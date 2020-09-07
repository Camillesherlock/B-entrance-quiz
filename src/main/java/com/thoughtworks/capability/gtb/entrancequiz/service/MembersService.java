package com.thoughtworks.capability.gtb.entrancequiz.service;

import com.thoughtworks.capability.gtb.entrancequiz.domain.Group;
import com.thoughtworks.capability.gtb.entrancequiz.domain.Members;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class MembersService {
    private List<Members> allMembers = initAllMembers();
    private int index = 35;
    static List<String> teamName = new ArrayList<String>() {
        {
            add("Team 1");
            add("Team 2");
            add("Team 3");
            add("Team 4");
            add("Team 5");
            add("Team 6");
        }
    };
    public List<Members> initAllMembers() {
        Members member = new Members(1,"廖浚斌");
        List<Members> members = new ArrayList<>();
        members.add(member);
        members.add(new Members(2,"徐慧慧"));
        members.add(new Members(3,"陈思聪"));
        members.add(new Members(4,"王江林"));
        members.add(new Members(5,"王登宇"));
        members.add(new Members(6,"杨思雨"));
        members.add(new Members(7,"江雨舟"));
        members.add(new Members(8,"廖燊"));
        members.add(new Members(9,"胡晓"));
        members.add(new Members(10,"但杰"));
        members.add(new Members(11,"盖迈达"));
        members.add(new Members(12,"肖美琦"));
        members.add(new Members(13,"黄云洁"));
        members.add(new Members(14,"齐瑾浩"));
        members.add(new Members(15,"刘亮亮"));
        members.add(new Members(16,"肖逸凡"));
        members.add(new Members(17,"王作文"));
        members.add(new Members(18,"郭瑞凌"));
        members.add(new Members(19,"李明豪"));
        members.add(new Members(20,"党泽"));
        members.add(new Members(21,"肖伊佐"));
        members.add(new Members(22,"贠晨曦"));
        members.add(new Members(23,"李康宁"));
        members.add(new Members(24,"马庆"));
        members.add(new Members(25,"商婕"));
        members.add(new Members(26,"余榕"));
        members.add(new Members(27,"谌哲"));
        members.add(new Members(28,"董翔锐"));
        members.add(new Members(29,"陈泰宇"));
        members.add(new Members(30,"赵允齐"));
        members.add(new Members(31,"张柯"));
        members.add(new Members(32,"廖文强"));
        members.add(new Members(33,"刘轲"));
        members.add(new Members(34,"廖浚斌"));
        members.add(new Members(35,"凌凤仪"));
        return members;
    }

    public List<Members> getAllMembers(){
        return allMembers;
    }

    public void addMembers(String name){
        index++;
        Members member = new Members(index,name);
        allMembers.add(member);
    }
    static public List<Group> studentsGroup;
    private void initGroup() {
        studentsGroup = new ArrayList<>();
    }
    public List<Group> getStudentsGroup() {
        initGroup();
        Collections.shuffle(allMembers);
        int perGroup = allMembers.size() / 6;
        int restToAdd = 0;
        if (perGroup * 6 < index) {
            restToAdd = index - perGroup * 6;
        }

        int total = 0;
        for (int i = 0; i < 6; i += 1) {
            List<Members> tmp = new ArrayList<>();
            int tmpAdd = restToAdd > 0 ? perGroup + 1 : perGroup;
            for (int j = 0; j < tmpAdd; j += 1) {
                if (total <= index) {
                    tmp.add(allMembers.get(i * perGroup + j));
                    total += 1;
                }
            }
            restToAdd -= 1;
            Group eachGroup = new Group(teamName.get(i), tmp);
            studentsGroup.add(eachGroup);
        }

        return studentsGroup;
    }
};
