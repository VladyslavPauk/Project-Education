package work.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import work.model.*;
import work.service.SubgroupServiceImp;
import work.service.TeacherServiceImp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherServiceImp teacherServiceImp;
    @Autowired
    private SubgroupServiceImp subgroupServiceImp;

    @GetMapping("/{id}")
    public String getTeacherById(@PathVariable("id") int id, Model model) {
        Teacher teacher = teacherServiceImp.getTeacherById(id);
        model.addAttribute("teacher", teacher);
        model.addAttribute("subgroupLessonSetMap", teacherServiceImp.getSubgroupLessonSetMap(teacher.getSubgroupSet()));
        return "teacher/teacher";
    }

    @GetMapping("/new")
    public String createTeacher(Model model) {                             // form for create teacher
        model.addAttribute("teacher", new Teacher());
        model.addAttribute("subgroupList", subgroupServiceImp.getAllSubgroup());
        return "/teacher/new";
    }

    @PostMapping("/new")                                                // create teacher
    public String saveTeacher(@ModelAttribute("teacher") Teacher teacher, @RequestParam("subgroups") int[] subgroupsId) {
        Set<Subgroup> subgroupSet = new HashSet<>();
        for (int i : subgroupsId) {
            subgroupSet.add(subgroupServiceImp.getSubgroupById(i));
        }
        teacher.setSubgroupSet(subgroupSet);
        teacher.setGradeList(new ArrayList<Grade>());
        teacher.setLessonList(new ArrayList<Lesson>());
        teacherServiceImp.saveTeacher(teacher);
        return "redirect:/login";
    }

    @DeleteMapping("/{id}")                                             //delete teacher
    public String deleteTeacher(@PathVariable("id") int id) {
        teacherServiceImp.deleteTeacher(teacherServiceImp.getTeacherById(id));
        return "redirect:/login";
    }

    @GetMapping("/{id}/edit")                                          //form for update teacher
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("teacherToBeUpdate", teacherServiceImp.getTeacherById(id));
        model.addAttribute("subgroupList", subgroupServiceImp.getAllSubgroup());
        return "/teacher/updateTeacher";
    }

    @PatchMapping("/{id}")                                           // update student
    public String updateTeacher(@RequestParam("name") String name, @RequestParam("surname") String surname,
                                @RequestParam("email") String email, @RequestParam("password") String password,
                                @PathVariable("id") int teacherId, Model model) {
        Teacher teacher = teacherServiceImp.getTeacherById(teacherId);
        teacher.setName(name);
        teacher.setSurname(surname);
        teacher.setPassword(password);
        teacher.setEmail(email);
        teacherServiceImp.updateTeacher(teacher);
        model.addAttribute("teacher", teacherServiceImp.getTeacherById(teacherId));
        return "teacher/teacher";
    }
}

