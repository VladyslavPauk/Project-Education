package org.journal.controller;

import org.journal.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.journal.service.GroupServiceImp;
import org.journal.service.TeacherServiceImp;


@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherServiceImp teacherServiceImp;
    @Autowired
    private GroupServiceImp groupServiceImp;

    @GetMapping("/{id}")
    public String getTeacher(@PathVariable("id") int id, Model model) {
        Teacher teacher = teacherServiceImp.getTeacher(id);
        model.addAttribute("teacher", teacher);
        model.addAttribute("GroupLessonsMap", teacherServiceImp.getGroupLessonsMap(teacher.getGroupSet()));
        return "teacher/teacher";
    }

    @GetMapping("/new")
    public String createTeacher(Model model) {
        model.addAttribute("teacher", new Teacher());
        model.addAttribute("groups", groupServiceImp.getGroups());
        return "/teacher/new";
    }

    @PostMapping("/new")
    public String saveTeacher(@ModelAttribute("teacher") Teacher teacher, @RequestParam("groups") int[] groupsId) {
        teacherServiceImp.saveTeacher(teacher, groupsId);
        return "redirect:/login";
    }

    @DeleteMapping("/{id}")
    public String deleteTeacher(@PathVariable("id") int id) {
        teacherServiceImp.deleteTeacher(teacherServiceImp.getTeacher(id));
        return "redirect:/login";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("teacherToBeUpdate", teacherServiceImp.getTeacher(id));
        return "/teacher/updateTeacher";
    }

    @PutMapping("/{id}")
    public String updateTeacher(@ModelAttribute Teacher teacher, @PathVariable("id") int teacherId) {
        teacherServiceImp.updateTeacher(teacher, teacherId);
        return "redirect:/teacher/" + teacherId;
    }
}

