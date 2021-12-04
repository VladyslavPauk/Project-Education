package org.journal.controller;

import org.journal.service.GroupService;
import org.journal.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.journal.model.Student;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;                    //TODO DTO-class
    @Autowired
    private GroupService groupService;                        //TODO change to interface

    @GetMapping("/new")
    public String createStudentPage(Model model) {              //TODO dont send new Student
        model.addAttribute("groups", groupService.getAllGroups()); // TODO rename method getallgroup/and only id
        return "student/new";
    }

    @PostMapping()                                        //TODO delete new, refactor parameter method
    public String saveStudent(@ModelAttribute("student") Student student, @RequestParam("id") int groupId) {
        studentService.saveStudent(student, groupId);
        return "redirect:/login";
    }

    @GetMapping("/{id}")
    public String getStudent(@PathVariable("id") int id, Model model) {
        Student student = studentService.getStudent(id);
        model.addAttribute("student", student);
        model.addAttribute("gradesPerLesson", studentService.getGradesPerLesson(student)); //TODO send to parameter "student" and get all in service/ rename method to gradesPerLesson
        model.addAttribute("averageGradePerLesson", studentService.getAverageGradePerLesson(studentService.getGradesPerLesson(student))); //TODO rename method averageGradePerLesson
        return "student/student";
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable("id") int id) {
        studentService.deleteStudent(id);
        return "redirect:/login";
    }

    @GetMapping("/{id}/edit")                                         //TODO rename url "edit" id-requestParam
    public String editPage(@PathVariable("id") int id, Model model) {
        model.addAttribute("groups", groupService.getAllGroups()); //TODO send id.group
        model.addAttribute("studentToBeUpdate", studentService.getStudent(id));
        return "student/updateStudent";
    }

    @PutMapping("/{id}")
    public String updateStudent(@ModelAttribute Student student, @PathVariable("id") int studentId, @RequestParam("id") int groupId) {
        studentService.updateStudent(student, groupId);
        return "redirect:/student/" + studentId;
    }
}
