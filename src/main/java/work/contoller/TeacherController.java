package work.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import work.model.Grade;
import work.model.Lesson;
import work.model.Subgroup;
import work.model.Teacher;
import work.service.SubgroupServiceImp;
import work.service.TeacherServiceImp;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherServiceImp teacherServiceImp;
    @Autowired
    private SubgroupServiceImp subgroupServiceImp;

    @GetMapping("/{id}")
    public String getTeacherById(@PathVariable("id") int id, Model model) {
        model.addAttribute("teacher", teacherServiceImp.getTeacherById(id));
        model.addAttribute("subgroupList", subgroupServiceImp.getAllSubgroupByTeacherId(id));
        return "teacher/teacher";
    }

    @GetMapping("/new")
    public String createTeacher(Model model) {                             // form for create teacher
        model.addAttribute("teacher", new Teacher());
        model.addAttribute("subgroupList", subgroupServiceImp.getAllSubgroup());
        return "/teacher/new";
    }

    @PostMapping("/new")
    public String saveTeacher(@ModelAttribute("teacher") Teacher teacher, @RequestParam("subgroups") int[] subgroupsId) {
        List<Subgroup> subgroupList = new ArrayList<>();
        for (int i : subgroupsId) {
            subgroupList.add(subgroupServiceImp.getSubgroupById(i));
        }
        teacher.setSubgroupList(subgroupList);
        teacher.setGradeList(new ArrayList<Grade>());
        teacher.setLessonList(new ArrayList<Lesson>());
        teacherServiceImp.saveTeacher(teacher);
        return "redirect:/login";
    }
}

