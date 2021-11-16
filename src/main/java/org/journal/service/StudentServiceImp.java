package org.journal.service;

import org.journal.model.Grade;
import org.journal.model.Lesson;
import org.journal.model.Student;
import org.journal.repository.StudentRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.journal.model.Subgroup;

import java.util.*;

@Service
public class StudentServiceImp implements StudentService {
    @Autowired
    private StudentRepositoryImp studentsRepositoryImp;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Student> getStudents() {
        return studentsRepositoryImp.getStudents();
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
    public void updateStudent(Student student, Subgroup subgroup, int studentId) {
        student.setSubgroup(subgroup);
        student.setId(studentId);
        studentsRepositoryImp.updateStudent(student);
    }

    @Override
    public void saveStudent(Student student, Subgroup subgroup, HashSet<Grade> grades) {
        student.setSubgroup(subgroup);
        student.setGradeSet(grades);
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        studentsRepositoryImp.saveStudent(student);
    }

    public Map<String, List<Grade>> getLessonGradesMap(Set<Grade> grades, Set<Lesson> lessons) {
        Map<String, List<Grade>> lessonGradesMap = new HashMap<>();
        if (!grades.isEmpty()) {
            for (Grade grade : grades) {
                if (lessonGradesMap.containsKey(grade.getLesson().getName())) {
                    lessonGradesMap.get(grade.getLesson().getName()).add(grade);
                } else {
                    List<Grade> gradeList = new ArrayList<>();
                    gradeList.add(grade);
                    lessonGradesMap.put(grade.getLesson().getName(), gradeList);
                }
            }
        } else {
            for (Lesson lesson : lessons) {
                lessonGradesMap.put(lesson.getName(), new ArrayList<Grade>());
            }
        }
        return lessonGradesMap;
    }

    public Map<String, Double> getLessonAverageGradeMap(Map<String, List<Grade>> lessonGradesMap) {
        Map<String, Double> lessonAverageGradeMap = new HashMap<>();

        for (Map.Entry<String, List<Grade>> map : lessonGradesMap.entrySet()) {
            double averageGrade = 0;
            String lessonName = map.getKey();
            List<Grade> gradeList = map.getValue();

            double sum = 0;
            if (gradeList.isEmpty()) {
                lessonAverageGradeMap.put(lessonName, 0.0);
            } else {
                for (Grade grade : gradeList) {
                    sum = sum + grade.getValue();
                }
                averageGrade = sum / gradeList.size();
                lessonAverageGradeMap.put(lessonName, averageGrade);
            }
        }
        return lessonAverageGradeMap;
    }

    public Map<Student, List<Grade>> getStudentGradesMap(Set<Student> students, int lessonId) {
        Map<Student, List<Grade>> studentGradesMap = new HashMap<>();

        for (Student student : students) {
            Set<Grade> grades = student.getGradeSet();
            for (Grade grade : grades) {
                Lesson lesson = grade.getLesson();
                if (lesson.getId() == lessonId) {

                    if (studentGradesMap.containsKey(student)) {
                        studentGradesMap.get(student).add(grade);
                    } else {
                        List<Grade> gradeList = new ArrayList<>();
                        gradeList.add(grade);
                        studentGradesMap.put(student, gradeList);
                    }
                }
            }

        }
        return studentGradesMap;
    }
}
