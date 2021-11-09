package work.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import work.model.*;
import work.repository.GradeRepositoryImp;
import work.service.GradeServiceImp;
import work.service.LessonServiceImp;
import work.service.StudentServiceImp;
import work.service.SubgroupServiceImp;

import java.util.Set;

@Controller
@RequestMapping("/subgroup")
public class SubgroupController {
    @Autowired
    private SubgroupServiceImp subgroupServiceImp;
    @Autowired
    private LessonServiceImp lessonServiceImp;
    @Autowired
    private StudentServiceImp studentServiceImp;
    @Autowired
    private GradeServiceImp gradeServiceImp;

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
        Set<Student> students = subgroup.getStudentSet();
        model.addAttribute("lesson", lessonServiceImp.getLessonById(lessonId));
        model.addAttribute("studentGradeListMap", studentServiceImp.getStudentGradeListMap(students, lessonId));
        return "lesson/lesson";
    }

    @PostMapping("/{subgroupId}/student/{studentId}/lesson/{lessonId}/add")
    public String addGradeStudentInLesson(@PathVariable("subgroupId") int subgroupId, @PathVariable("studentId") int studentId,
                                          @PathVariable("lessonId") int lessonId, @RequestParam("grade") int gradeValue) {

        Student student = studentServiceImp.getStudent(studentId);
        Lesson lesson = lessonServiceImp.getLessonById(lessonId);
        Teacher teacher = lesson.getTeacher();
        Grade grade = gradeServiceImp.createGrade(gradeValue, lesson, student, teacher);
        gradeServiceImp.addGrade(grade);
        return "redirect:/subgroup/" + subgroupId + "/lesson/" + lessonId;
    }
}
