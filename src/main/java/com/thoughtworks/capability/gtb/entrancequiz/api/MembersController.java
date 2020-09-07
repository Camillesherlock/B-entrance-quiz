package com.thoughtworks.capability.gtb.entrancequiz.api;

import com.thoughtworks.capability.gtb.entrancequiz.domain.Members;
import com.thoughtworks.capability.gtb.entrancequiz.service.MembersService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MembersController {
    private final MembersService membersService;

    public MembersController(MembersService membersService) {
        this.membersService = membersService;
    }
    @GetMapping("/members")
    @CrossOrigin
    public List<Members> getAllMembers() {
        List<Members> list = membersService.getAllMembers();
        return list;
    }

    @PostMapping("/add-members")
    @CrossOrigin
    public void addMembers(String name) {
        membersService.addMembers(name);
    }
}
