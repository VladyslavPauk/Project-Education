package work.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping()
public class AuthController {

    @GetMapping("/signUp")
    public String getSignUp() {                                //form for choose teacher or student
        return "auth/choose";
    }

    @PostMapping("/signUp")                                 // choose who is who and redirect to create model
    public String signUp(@RequestParam("id") int id) {
        if(id == 1) {
            return "redirect:/teacher/new";
        }else
        return "redirect:/student/new";
    }

    @GetMapping("/login")                                               // form for login
    public String login(@RequestParam(value = "error", required = false) Boolean error, Model model) {
        if(Boolean.TRUE.equals(error)) {
            model.addAttribute("error", true);
        }
        return "auth/login";
    }
}
