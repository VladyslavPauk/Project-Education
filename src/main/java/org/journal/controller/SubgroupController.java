package org.journal.controller;

import org.journal.repository.StudentRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.journal.service.GradeServiceImp;
import org.journal.service.LessonServiceImp;
import org.journal.service.StudentServiceImp;
import org.journal.service.GroupServiceImp;

@Controller
@RequestMapping("/group")
public class SubgroupController {
    @Autowired
    private GroupServiceImp groupServiceImp;
    @Autowired
    private LessonServiceImp lessonServiceImp;
    @Autowired
    private StudentServiceImp studentServiceImp;
    @Autowired
    private GradeServiceImp gradeServiceImp;
    @Autowired
    StudentRepositoryImp studentRepositoryImp;

    @GetMapping("/{id}")
    public String getGroup(@PathVariable("id") int id, Model model) {
        model.addAttribute("group", groupServiceImp.getGroup(id));
        return "group/group";
    }

    @GetMapping
    public String getGroups(Model model) {
        model.addAttribute("groups", groupServiceImp.getGroups());
        return "group/groups";
    }

    @GetMapping("/{groupId}/lesson/{id}")
    public String getStudentInGroupOnLesson(@PathVariable("groupId") int groupId, @PathVariable("id") int lessonId, Model model) {
        model.addAttribute("lesson", lessonServiceImp.getLesson(lessonId));
        model.addAttribute("studentGradesMap", studentServiceImp.getStudentGradesMap(lessonId, groupId));
        return "lesson/lesson";
    }

    @PostMapping("/{groupId}/student/{studentId}/lesson/{lessonId}/addGrade")
    public String addGradeStudentInLesson(@PathVariable("groupId") int groupId, @PathVariable("studentId") int studentId,
                                          @PathVariable("lessonId") int lessonId, @RequestParam("grade") int gradeValue) {

        gradeServiceImp.addGrade(studentServiceImp.getStudent(studentId), lessonServiceImp.getLesson(lessonId), gradeValue);
        return "redirect:/subgroup/" + groupId + "/lesson/" + lessonId;
    }
}
