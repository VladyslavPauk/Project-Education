package org.journal.controller;

import org.journal.dto.StudentDTO;
import org.journal.dto.mapper.GradeMapper;
import org.journal.dto.mapper.GroupMapper;
import org.journal.dto.mapper.StudentMapper;
import org.journal.service.GroupService;
import org.journal.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.journal.model.Student;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private GroupService groupService;
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    GroupMapper groupMapper;
    @Autowired
    GradeMapper gradeMapper;


    @GetMapping("/new")
    public String createStudentPage(Model model) {
        model.addAttribute("groups", groupMapper.toGroupDtoList(groupService.getAllGroups()));
        return "student/new";
    }

    @PostMapping()
    public String saveStudent(@ModelAttribute("student") StudentDTO student, @RequestParam("id") int groupId) {
        studentService.saveStudent(studentMapper.studentDTOtoStudent(student), groupId);
        return "redirect:/login";
    }

    @GetMapping("/{id}")
    public String getStudent(@PathVariable("id") int id, Model model) {
        Student student = studentService.getStudent(id);
        model.addAttribute("student", studentMapper.toStudentDTO(student));
        model.addAttribute("gradesPerLesson", studentMapper.getGradesPerLessonDTo(studentService.getGradesPerLesson(student))) ;
        model.addAttribute("averageGradePerLesson", studentService.getAverageGradePerLesson(studentService.getGradesPerLesson(student)));
        return "student/student";
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable("id") int id) {
        studentService.deleteStudent(id);
        return "redirect:/login";
    }

    @GetMapping("/{id}/edit")
    public String editPage(@PathVariable("id") int id, Model model) {
        model.addAttribute("groups", groupMapper.toGroupDtoList(groupService.getAllGroups()));
        model.addAttribute("studentToBeUpdate", studentMapper.toStudentDTOWithoutEntity(studentService.getStudent(id)));
        return "student/updateStudent";
    }

    @PutMapping("/{id}")
    public String updateStudent(@ModelAttribute StudentDTO student, @PathVariable("id") int studentId, @RequestParam("id") int groupId) {
        studentService.updateStudent(studentMapper.studentDTOtoStudent(student), groupId, studentId);
        return "redirect:/student/" + studentId;
    }
}
