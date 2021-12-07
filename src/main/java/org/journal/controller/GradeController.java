package org.journal.controller;

import org.journal.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class GradeController {
    @Autowired
    private GradeService gradeService;

    @PostMapping("/group/{groupId}/student/{studentId}/lesson/{lessonId}/addGrade")
    //TODO rename, create new grade controller
    public String addGradeToStudentInGroupPerLesson(@PathVariable("groupId") int groupId, @PathVariable("studentId") int studentId,
                                                    @PathVariable("lessonId") int lessonId, @RequestParam("grade") int gradeValue) {

        gradeService.addGrade(studentId, lessonId, gradeValue);
        return "redirect:/group/" + groupId + "/lesson/" + lessonId;
    }
}
