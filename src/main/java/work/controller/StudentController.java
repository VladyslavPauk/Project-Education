package work.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import work.model.Grade;
import work.model.Student;
import work.service.SubgroupServiceImp;
import work.service.StudentServiceImp;
import java.util.HashSet;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentServiceImp studentServiceImp;
    @Autowired
    private SubgroupServiceImp subgroupServiceImp;

    @GetMapping("/new")
    public String createStudent(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("subgroups", subgroupServiceImp.getSubgroups());
        return "student/new";
    }

    @PostMapping("/new")
    public String saveStudent(@ModelAttribute("student") Student student, @RequestParam("id") int groupId) {
        studentServiceImp.saveStudent(student, subgroupServiceImp.getSubgroup(groupId), new HashSet<Grade>());
        return "redirect:/login";
    }

    @GetMapping
    public String getStudents(Model model) {
        model.addAttribute("students", studentServiceImp.getStudents());
        return "student/students";
    }

    @GetMapping("/{id}")
    public String getStudent(@PathVariable("id") int id, Model model) {
        Student student = studentServiceImp.getStudent(id);
        model.addAttribute("student", student);
        model.addAttribute("lessonGradesMap", studentServiceImp.getLessonGradesMap(student.getGradeSet()));
        model.addAttribute("lessonAverageGradeMap", studentServiceImp.getLessonAverageGradeMap(studentServiceImp.getLessonGradesMap(student.getGradeSet())));
        return "student/student";
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable("id") int id) {
        studentServiceImp.deleteStudent(id);
        return "redirect:/login";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("subgroups", subgroupServiceImp.getSubgroups());
        model.addAttribute("studentToBeUpdate", studentServiceImp.getStudent(id));
        return "student/updateStudent";
    }

    @PutMapping("/{id}")
    public String updateStudent(@ModelAttribute Student student, @PathVariable("id") int studentId, @RequestParam("id") int groupId) {
        studentServiceImp.updateStudent(student, subgroupServiceImp.getSubgroup(groupId), studentId);
        return "redirect:/student/" + studentId;
    }
}
