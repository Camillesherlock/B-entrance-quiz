package com.thoughtworks.capability.gtb.entrancequiz.api;

import com.thoughtworks.capability.gtb.entrancequiz.domain.Members;
import com.thoughtworks.capability.gtb.entrancequiz.service.MembersService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MembersController {
    private MembersService membersService;

    @GetMapping("/members")
    public List<Members> getAllMembers(){
        return membersService.getAllMembers();
    }

}
