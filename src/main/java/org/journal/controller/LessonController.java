package org.journal.controller;

import org.journal.dto.mapper.MapStructMapper;
import org.journal.service.LessonService;
import org.journal.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class LessonController {
    @Autowired
    private LessonService lessonService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private MapStructMapper mapStructMapper;

    @GetMapping("/group/{groupId}/lesson/{id}")
    //TODO rename method "getgradesperlessoningroup" and this method need be in lesson controller
    public String getGradesPerLessonInGroup(@PathVariable("groupId") int groupId, @PathVariable("id") int lessonId, Model model) {
        model.addAttribute("lesson", lessonService.getLesson(lessonId));
        model.addAttribute("gradesPerLessonInGroup", studentService.getGradesPerLessonInGroup(lessonId, groupId)); //TODO rename gradesPerLesson
        return "lesson/lesson";
    }
}
