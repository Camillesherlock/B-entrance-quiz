package com.thoughtworks.capability.gtb.entrancequiz.api;

import com.thoughtworks.capability.gtb.entrancequiz.domain.Group;
import com.thoughtworks.capability.gtb.entrancequiz.domain.Members;
import com.thoughtworks.capability.gtb.entrancequiz.service.MembersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class MembersController {
    private final MembersService membersService;

    public MembersController(MembersService membersService) {
        this.membersService = membersService;
    }
    @GetMapping("/members")
    public List<Members> getAllMembers() {
        List<Members> list = membersService.getAllMembers();
        return list;
    }

    @PostMapping("/addMembers/{name}")
    public ResponseEntity addMembers(@PathVariable("name") String name) {
        membersService.addMembers(name);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/membersGroup")
    public ResponseEntity<List<Group>> getStudentsGroup() {
        return ResponseEntity.ok(membersService.getStudentsGroup());
    }

    @PutMapping("/team/{originName}/{name}")
    public ResponseEntity changeTeamName(@PathVariable("originName") String originName,
                                         @PathVariable("name") String name) {
        try{
            membersService.changeTeamName(originName, name);
            return ResponseEntity.ok().build();
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }


    }
}
