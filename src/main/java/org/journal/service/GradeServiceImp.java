package org.journal.service;

import org.journal.model.Grade;
import org.journal.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GradeServiceImp implements GradeService {
    @Autowired
    private GradeRepository gradeRepository;
    @Autowired
    private StudentService studentService;
    @Autowired
    private LessonService lessonService;

    public void addGrade(int studentId, int lessonId, int gradeValue) {
        Grade grade = new Grade();
        grade.setValue(gradeValue);
        grade.setTeacher(lessonService.getLesson(lessonId).getTeacher());
        grade.setLesson(lessonService.getLesson(lessonId));
        grade.setStudent(studentService.getStudent(studentId));
        gradeRepository.addGrade(grade);
    }
}
