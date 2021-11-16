package org.journal.service;

import org.journal.model.Grade;
import org.journal.model.Lesson;
import org.journal.model.Student;
import org.journal.repository.GradeRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GradeServiceImp implements GradeService{
    @Autowired
    private GradeRepositoryImp gradeRepositoryImp;

    public void addGrade(Student student, Lesson lesson, int gradeValue) {
        Grade grade = new Grade();
        grade.setValue(gradeValue);
        grade.setTeacher(lesson.getTeacher());
        grade.setLesson(lesson);
        grade.setStudent(student);
        gradeRepositoryImp.addGrade(grade);
    }
}
