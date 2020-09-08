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
    private List<Members> originMembers = initAllMembers();
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
        String[] studentName = {"廖浚斌","徐慧慧","陈思聪","王江林","王登宇","杨思雨","江雨舟","廖燊",
        "胡晓","但杰","盖迈达","肖美琦","黄云洁","齐瑾浩","刘亮亮","肖逸凡","王作文","郭瑞凌","李明豪",
        "党泽","肖伊佐","贠晨曦","李康宁","马庆","商婕","余榕","谌哲","董翔锐","陈泰宇","赵允齐","张柯","廖文强",
        "刘轲","廖浚斌","凌凤仪"};
        List<Members> members = new ArrayList<>();
        for(int i =0; i < 35; i++) {
            Members member = new Members(i + 1, studentName[i]);
            members.add(member);
        }
        return members;
    }

    public List<Members> getAllMembers(){
        return originMembers;
    }

    public void addMembers(String name){
        index++;
        Members member = new Members(index,name);
        allMembers.add(member);
        originMembers.add(member);
    }
    static public List<Group> studentsGroup;
    private void initGroup() {
        studentsGroup = new ArrayList<>();
    }
    public List<Group> getStudentsGroup() {
        initGroup();
        Collections.shuffle(allMembers);
        int perGroup = allMembers.size() / 6;
        int restToAdd = allMembers.size() % 6;
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
    public void changeTeamName(String originName, String name) throws Exception {
        if (Collections.frequency(teamName, name) > 0) {
            throw new Exception("CONFLICT Team Name");
        } else {
            teamName.set(teamName.indexOf(originName), name);
        }
    }
};
