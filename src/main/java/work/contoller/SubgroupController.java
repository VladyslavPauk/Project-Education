package work.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import work.model.Lesson;
import work.model.Subgroup;
import work.service.LessonServiceImp;
import work.service.StudentServiceImp;
import work.service.SubgroupServiceImp;


@Controller
@RequestMapping("/subgroup")
public class SubgroupController {
    @Autowired
    private SubgroupServiceImp subgroupServiceImp;
    @Autowired
    private LessonServiceImp lessonServiceImp;
    @Autowired
    private StudentServiceImp studentServiceImp;

    @GetMapping("/{id}")
    public String getSubgroupById(@PathVariable("id") int id, Model model) {
        Subgroup subgroup = subgroupServiceImp.getSubgroupById(id);
        model.addAttribute("subgroup", subgroup);
        model.addAttribute("studentSet", subgroup.getStudentSet());
        return "subgroup/subgroup";
    }
    @GetMapping
    public String getAllSubgroups(Model model) {
        model.addAttribute("subgroupList", subgroupServiceImp.getAllSubgroup());
        return "subgroup/subgroups";
    }

    @GetMapping("/{subgroupId}/lesson/{id}")
    public String getStudentInSubgroupOnLesson(@PathVariable("subgroupId") int subgroupId, @PathVariable("id") int lessonId, Model model) {
        Subgroup subgroup = subgroupServiceImp.getSubgroupById(subgroupId);
        Lesson lesson =  lessonServiceImp.getLessonById(lessonId);
        model.addAttribute("studentGradeSetMap", studentServiceImp.getStudentGradeSetMap(subgroup,lesson));
        return "lesson/lesson";
    }

}
