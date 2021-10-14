package work.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import work.model.Grade;
import work.model.Subgroup;
import work.model.Student;
import work.service.SubgroupServiceImp;
import work.service.StudentServiceImp;

import java.util.ArrayList;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentServiceImp studentServiceImp;
    @Autowired
    private SubgroupServiceImp subgroupServiceImp;

    @GetMapping("/new")
    public String createStudent(Model model) {                       //form for create student
        model.addAttribute("student", new Student());
        model.addAttribute("subgroupList", subgroupServiceImp.getAllSubgroup());
        return "student/new";
    }

    @PostMapping  ("/new")                                               //create student
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
        model.addAttribute("student", studentServiceImp.getStudent(id));
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

    @PatchMapping("/{id}")                                           // update student
    public String updateStudent(@RequestParam("name") String name, @RequestParam("surname") String surname,
                                @RequestParam("email") String email, @RequestParam("password") String password,
                                @RequestParam("id") int subgroupId, @PathVariable("id") int studentId, Model model) {
     Student student = studentServiceImp.getStudent(studentId);
     if(name != student.getName() || surname != student.getSurname() ||
        email != student.getEmail() || password != student.getPassword() ||
        student.getSubgroup().getId() != subgroupId) {
         student.setName(name);
         student.setSurname(surname);
         student.setPassword(password);
         student.setEmail(email);
         student.setSubgroup(subgroupServiceImp.getSubgroupById(subgroupId));
     }
     studentServiceImp.updateStudent(student);
     model.addAttribute("student", studentServiceImp.getStudent(studentId));
        return "student/student";
    }
}
