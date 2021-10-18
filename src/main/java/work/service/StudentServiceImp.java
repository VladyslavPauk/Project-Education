package work.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import work.model.Grade;
import work.model.Student;
import work.repository.StudentRepositoryImp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImp implements StudentService {
    @Autowired
    private StudentRepositoryImp studentsRepositoryImp;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public List<Student> getAllStudents() {
        return studentsRepositoryImp.getAllStudents();
    }

    @Override
    public Student getStudent(int id) {
        return studentsRepositoryImp.getStudent(id);
    }

    public Student getStudent(String email) {
        return studentsRepositoryImp.getStudent(email);
    }

    @Override
    public void deleteStudent(int id) {
        studentsRepositoryImp.deleteStudent(id);
    }

    @Override
    public void updateStudent(Student student) {
        studentsRepositoryImp.updateStudent(student);
    }

    @Override
    public void setStudent(Student student) {
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        studentsRepositoryImp.setStudent(student);
    }

    public Map<String, List<Grade>> getLessonGradeList(List<Grade> grades) {
        Map<String, List<Grade>> lessonGradeList = new HashMap<>();
        List<Grade> gradeList = new ArrayList<>();
        for(Grade grade: grades) {
            if(!lessonGradeList.containsKey(grade.getLesson().getName())) {
                gradeList.add(grade);
                lessonGradeList.put(grade.getLesson().getName(),gradeList);
            } else
                lessonGradeList.get(grade.getLesson().getName()).add(grade);
        }
        return lessonGradeList;
    }

}
