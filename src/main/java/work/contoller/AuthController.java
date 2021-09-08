package work.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import work.model.Student;
import work.model.University;
import work.service.StudentServiceImp;
import work.service.UniversityServiceImp;

@Controller
@RequestMapping()
public class AuthController {
    @Autowired
    UniversityServiceImp universityServiceImp;
    @Autowired
    StudentServiceImp studentServiceImp;

    @GetMapping("/signUp")
    public String GetSignUp(Model model) {                                //form for create Student
        model.addAttribute("universeList", universityServiceImp.getAllUniversity());
        return "auth/signUp";
    }

    @PostMapping("/signUp")
    public String signUp(@RequestParam("name") String name, @RequestParam("id") int id,
                         @RequestParam("password") String password, @RequestParam("email") String email) {
        University u = universityServiceImp.getUniversity(id);              // create student
        Student student = new Student();
        student.setName(name);
        student.setPassword(password);
        student.setUniversity(u);
        student.setEmail(email);
        studentServiceImp.setStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/login")                                               // form for login
    public String login() {                                               // form for login
        return "auth/login";
    }
}
