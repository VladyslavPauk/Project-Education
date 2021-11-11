package work.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import work.model.*;
import work.repository.GradeRepositoryImp;

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
