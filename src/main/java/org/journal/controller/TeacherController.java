package org.journal.controller;

import org.journal.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.journal.service.SubgroupServiceImp;
import org.journal.service.TeacherServiceImp;


@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherServiceImp teacherServiceImp;
    @Autowired
    private SubgroupServiceImp subgroupServiceImp;

    @GetMapping("/{id}")
    public String getTeacher(@PathVariable("id") int id, Model model) {
        Teacher teacher = teacherServiceImp.getTeacher(id);
        model.addAttribute("teacher", teacher);
        model.addAttribute("subgroupLessonsMap", teacherServiceImp.getSubgroupLessonsMap(teacher.getSubgroupSet()));
        return "teacher/teacher";
    }

    @GetMapping("/new")
    public String createTeacher(Model model) {
        model.addAttribute("teacher", new Teacher());
        model.addAttribute("subgroups", subgroupServiceImp.getSubgroups());
        return "/teacher/new";
    }

    @PostMapping("/new")
    public String saveTeacher(@ModelAttribute("teacher") Teacher teacher, @RequestParam("subgroups") int[] subgroupsId) {
        teacherServiceImp.saveTeacher(teacher, subgroupsId);
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

