package work.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import work.model.Grade;
import work.model.Lesson;
import work.model.Subgroup;
import work.model.Student;
import work.service.SubgroupServiceImp;
import work.service.StudentServiceImp;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentServiceImp studentServiceImp;
    @Autowired
    private SubgroupServiceImp subgroupServiceImp;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/new")
    public String createStudent(Model model) {                       //form for create student
        model.addAttribute("student", new Student());
        model.addAttribute("subgroupList", subgroupServiceImp.getAllSubgroup());
        return "student/new";
    }

    @PostMapping("/new")                                               //create student
    public String setStudent(@ModelAttribute("student") Student student, @RequestParam("id") int groupId) {
        Subgroup subgroup = subgroupServiceImp.getSubgroupById(groupId);
        student.setSubgroup(subgroup);
        student.setGradeList(new ArrayList<Grade>());
        studentServiceImp.setStudent(student);
        return "redirect:/login";
    }

    @GetMapping
    public String getAllStudents(Model model) {                       // get all student
        model.addAttribute("students", studentServiceImp.getAllStudents());
        return "student/students";
    }

    @GetMapping("/{id}")                                         // get one Student
    public String getStudent(@PathVariable("id") int id, Model model) {
        Student student = studentServiceImp.getStudent(id);
        List<Lesson> lessonList = student.getSubgroup().getLessonList();
        model.addAttribute("lessonList", lessonList);
        model.addAttribute("student",student);
        List<Grade> list = student.getGradeList();
        model.addAttribute("map", studentServiceImp.getLessonGradeList(list));
        return "student/student";
    }

    @DeleteMapping("/{id}")                                         // delete student
    public String deleteStudent(@PathVariable("id") int id) {
        studentServiceImp.deleteStudent(id);
        return "redirect:/login";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {      // form for update student
        model.addAttribute("subgroupList", subgroupServiceImp.getAllSubgroup());
        model.addAttribute("studentToBeUpdate", studentServiceImp.getStudent(id));
        return "student/updateStudent";
    }

    @PutMapping("/{id}")
    public String updateStudent (@ModelAttribute Student student, @PathVariable("id") int studentId, @RequestParam("id") int groupId, Model model) {
         Subgroup subgroup = subgroupServiceImp.getSubgroupById(groupId);
         student.setId(studentId);
         student.setSubgroup(subgroup);
         studentServiceImp.updateStudent(student);
         model.addAttribute("student", student);
        return "student/student";
    }
}
