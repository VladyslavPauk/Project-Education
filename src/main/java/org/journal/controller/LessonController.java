package org.journal.controller;

import org.journal.dto.mapper.GradeMapper;
import org.journal.dto.mapper.GroupMapper;
import org.journal.dto.mapper.LessonMapper;
import org.journal.dto.mapper.StudentMapper;
import org.journal.service.GroupService;
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
    private GroupService groupService;
    @Autowired
    LessonMapper lessonMapper;
    @Autowired
    GroupMapper groupMapper;
    @Autowired
    StudentMapper studentMapper;

    @GetMapping("/group/{groupId}/lesson/{id}")
    //TODO rename method "getgradesperlessoningroup" and this method need be in lesson controller
    public String getGradesPerLessonInGroup(@PathVariable("groupId") int groupId, @PathVariable("id") int lessonId, Model model) {
        model.addAttribute("lesson", lessonMapper.toLessonDTO(lessonService.getLesson(lessonId)));
        model.addAttribute("group", groupMapper.toGroupDTOWithoutEntity(groupService.getGroup(groupId)));
        model.addAttribute("gradesPerLessonInGroup", studentMapper.ToGradesPerLessonInGroupDTO(studentService.getGradesPerLessonInGroup(lessonId, groupId))); //TODO rename gradesPerLesson
        return "lesson/lesson";
    }
}
