package org.journal.controller;

import org.journal.dto.TeacherDTO;
import org.journal.dto.mapper.TeacherMapper;
import org.journal.model.Teacher;
import org.journal.service.GroupService;
import org.journal.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private GroupService groupService;
    @Autowired
    TeacherMapper teacherMapper;


    @GetMapping("/{id}")
    public String getTeacher(@PathVariable("id") int id, Model model) {
        Teacher teacher = teacherService.getTeacher(id);
        model.addAttribute("teacher", teacherMapper.toTeacherDTO(teacher));
        model.addAttribute("lessonsPerGroup", teacherMapper.toLessonsPerGroupDTO(teacherService.getLessonsPerGroup(teacher)));
        return "teacher/teacher";
    }

    @GetMapping("/new")
    public String createTeacher(Model model) {
        model.addAttribute("groups", groupService.getAllGroups());
        return "/teacher/new";
    }

    @PostMapping()
    public String saveTeacher(@ModelAttribute("teacher") TeacherDTO teacher, @RequestParam("groups") int[] groupsId) {
        teacherService.saveTeacher(teacherMapper.teacherDTotoTeacher(teacher), groupsId);
        return "redirect:/login";
    }

    @DeleteMapping("/{id}")
    public String deleteTeacher(@PathVariable("id") int id) {
        teacherService.deleteTeacher(teacherService.getTeacher(id));
        return "redirect:/login";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("teacherToBeUpdate", teacherMapper.toTeacherDTO(teacherService.getTeacher(id)));
        return "/teacher/updateTeacher";
    }

    @PutMapping("/{id}")
    public String updateTeacher(@ModelAttribute TeacherDTO teacher, @PathVariable("id") int teacherId) {
        teacherService.updateTeacher(teacherMapper.teacherDTotoTeacher(teacher));
        return "redirect:/teacher/" + teacherId;
    }
}

