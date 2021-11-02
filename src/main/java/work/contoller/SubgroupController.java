package work.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import work.model.Grade;
import work.model.Lesson;
import work.model.Student;
import work.model.Subgroup;
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
        model.addAttribute("studentGradeListMap", studentServiceImp.getStudentGradeListMap(students, lessonId));
        return "lesson/lesson";
    }

    @PostMapping("/student/{studentId}/lesson/{lessonId}/add}")
    public String addGradeStudentInLesson(@PathVariable("subgroupId") int subgroupId, @PathVariable("studentId") int studentId,
                                          @PathVariable("lessonId") int lessonId, @RequestParam("grade") int gradeValue) {

        Student student = studentServiceImp.getStudent(studentId);
        Grade grade = new Grade();
        grade.setValue(gradeValue);
        Lesson lesson = lessonServiceImp.getLessonById(lessonId);
        grade.setLesson(lesson);
        grade.setStudent(student);
        grade.setTeacher(lesson.getTeacher());
        student.getGradeSet().add(grade);
        studentServiceImp.updateStudent(student);
        return "lesson/lesson";

    }

}
