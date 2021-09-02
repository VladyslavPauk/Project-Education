package work.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import work.model.Student;
import work.model.University;
import work.service.StudentServiceImp;
import work.service.UniversityServiceImp;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentServiceImp studentServiceImp;
    @Autowired
    UniversityServiceImp universityServiceImp;

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

    @GetMapping("/new")                                          // form for create student
    public String createStudent(Model model) {
        model.addAttribute("universeList", universityServiceImp.getAllUniversity());
        return "student/createStudent";
    }

    @PostMapping()                                                // create student
    public String addStudent(@RequestParam("name") String name, @RequestParam("id") int id) {
        University u = universityServiceImp.getUniversity(id);
        Student student = new Student();
        student.setName(name);
        student.setUniversity(u);
        studentServiceImp.setStudent(student);
        return "redirect:/students";
    }

    @DeleteMapping("/{id}")                                         // delete student
    public String deleteStudent(@PathVariable("id") int id) {
        studentServiceImp.deleteStudent(id);
        return "redirect:/students";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {      // form for update student
        model.addAttribute("studentToBeUpdate", studentServiceImp.getStudent(id));
        return "student/updateStudent";
    }

    @PatchMapping("/{id}")                                           // update student
    public String updateStudent(@ModelAttribute("student") Student student) {
        studentServiceImp.updateStudent(student);
        return "redirect:/students";
    }
}
