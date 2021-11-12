package org.journal.service;

import org.journal.model.Grade;
import org.journal.model.Lesson;
import org.journal.model.Student;
import org.journal.repository.GradeRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.journal.model.*;

@Service
public class GradeServiceImp implements GradeService{
    @Autowired
    private GradeRepositoryImp gradeRepositoryImp;
    @Override
    public void addGrade(Grade grade) {
        gradeRepositoryImp.addGrade(grade);
    }

    public void createGrade(Student student, Lesson lesson, int gradeValue) {
        Grade grade = new Grade();
        grade.setValue(gradeValue);
        grade.setTeacher(lesson.getTeacher());
        grade.setLesson(lesson);
        grade.setStudent(student);
        addGrade(grade);
    }
}
