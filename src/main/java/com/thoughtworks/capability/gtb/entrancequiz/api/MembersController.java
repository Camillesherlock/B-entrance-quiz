package com.thoughtworks.capability.gtb.entrancequiz.api;

import com.thoughtworks.capability.gtb.entrancequiz.domain.Members;
import com.thoughtworks.capability.gtb.entrancequiz.service.MembersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/addMembers/{name}")
    @CrossOrigin
    public ResponseEntity addMembers(@PathVariable("name") String name) {
        membersService.addMembers(name);
        return ResponseEntity.ok().build();
    }
}
