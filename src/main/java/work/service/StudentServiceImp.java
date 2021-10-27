package work.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import work.model.Grade;
import work.model.Lesson;
import work.model.Student;
import work.model.Subgroup;
import work.repository.StudentRepositoryImp;

import java.util.*;

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

    public Map<String, List<Grade>> getMapLessonGrade(Set<Grade> grades) {
        Map<String, List<Grade>> lessonGradeList = new HashMap<>();
        for (Grade grade : grades) {
            if (lessonGradeList.containsKey(grade.getLesson().getName())) {
                lessonGradeList.get(grade.getLesson().getName()).add(grade);
            } else {
                List<Grade> gradeList = new ArrayList<>();
                gradeList.add(grade);
                lessonGradeList.put(grade.getLesson().getName(), gradeList);
            }
        }
        return lessonGradeList;
    }

    public Map<String, Double> getMapLessonAverageGrade(Map<String, List<Grade>> mapLessonGrade) {
        Map<String, Double> mapLessonAverageGrade = new HashMap<>();

        for (Map.Entry<String, List<Grade>> map : mapLessonGrade.entrySet()) {
            double averageGrade = 0;
            String lessonName = map.getKey();
            List<Grade> gradeList = map.getValue();

            double sum = 0;
            for (Grade grade : gradeList) {
                sum = sum + grade.getValue();
            }
            averageGrade = sum / gradeList.size();
            mapLessonAverageGrade.put(lessonName, averageGrade);
        }
        return mapLessonAverageGrade;
    }

    public Map<Student, Set<Grade>> getStudentGradeSetMap(Subgroup subgroup, Lesson lesson) {
        Map<Student, Set<Grade>> studentGradeSetMap = new HashMap<>();
        Set<Student> studentSet = subgroup.getStudentSet();
        for(Student student : studentSet) {
            studentGradeSetMap.put(student, lesson.getGradeSet());
        }
        return studentGradeSetMap;
    }
}
