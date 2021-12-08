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
    @Autowired
    GroupMapper groupMapper;




    @GetMapping("/{id}")
    public String getGroup(@PathVariable("id") int id, Model model) {
        model.addAttribute("group", groupMapper.toGroupDTO(groupService.getGroup(id)));
        return "group/group";
    }

    @GetMapping
    public String getAllGroups(Model model) {
        model.addAttribute("groups", groupMapper.toGroupDtoList(groupService.getAllGroups()));
        return "group/groups";
    }

}
