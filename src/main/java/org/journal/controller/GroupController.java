package org.journal.controller;

import org.journal.dto.mapper.GroupMapper;
import org.journal.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/group")
public class GroupController {
    @Autowired
    private GroupService groupService;




    @GetMapping("/{id}")
    public String getGroup(@PathVariable("id") int id, Model model) {
        model.addAttribute("group", groupService.getGroup(id));
        return "group/group";
    }

    @GetMapping
    public String getAllGroups(Model model) {
        model.addAttribute("groups", groupService.getAllGroups());
        return "group/groups";
    }

}
