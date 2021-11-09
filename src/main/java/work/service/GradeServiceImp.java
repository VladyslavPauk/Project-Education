package work.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import work.model.Grade;
import work.model.Lesson;
import work.model.Student;
import work.model.Teacher;
import work.repository.GradeRepositoryImp;

@Service
public class GradeServiceImp implements GradeService{
    @Autowired
    GradeRepositoryImp gradeRepositoryImp;
    @Override
    public void addGrade(Grade grade) {
        gradeRepositoryImp.addGrade(grade);
    }

    public Grade createGrade(int value, Lesson lesson, Student student, Teacher teacher) {
        Grade grade = new Grade();
        grade.setValue(value);
        grade.setTeacher(teacher);
        grade.setLesson(lesson);
        grade.setStudent(student);
        return grade;
    }
}
