package org.journal.controller;

import org.journal.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.journal.service.GradeServiceImp;
import org.journal.service.LessonServiceImp;
import org.journal.service.StudentServiceImp;
import org.journal.service.SubgroupServiceImp;
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
    public String getSubgroup(@PathVariable("id") int id, Model model) {
        model.addAttribute("subgroup", subgroupServiceImp.getSubgroup(id));
        return "subgroup/subgroup";
    }

    @GetMapping
    public String getSubgroups(Model model) {
        model.addAttribute("subgroups", subgroupServiceImp.getSubgroups());
        return "subgroup/subgroups";
    }

    @GetMapping("/{subgroupId}/lesson/{id}")
    public String getStudentInSubgroupOnLesson(@PathVariable("subgroupId") int subgroupId, @PathVariable("id") int lessonId, Model model) {
        Set<Student> students = subgroupServiceImp.getSubgroup(subgroupId).getStudentSet();
        model.addAttribute("lesson", lessonServiceImp.getLesson(lessonId));
        model.addAttribute("studentGradesMap", studentServiceImp.getStudentGradesMap(students, lessonId));
        return "lesson/lesson";
    }

    @PostMapping("/{subgroupId}/student/{studentId}/lesson/{lessonId}/addGrade")
    public String addGradeStudentInLesson(@PathVariable("subgroupId") int subgroupId, @PathVariable("studentId") int studentId,
                                          @PathVariable("lessonId") int lessonId, @RequestParam("grade") int gradeValue) {

        gradeServiceImp.addGrade(studentServiceImp.getStudent(studentId), lessonServiceImp.getLesson(lessonId), gradeValue);
        return "redirect:/subgroup/" + subgroupId + "/lesson/" + lessonId;
    }
}
