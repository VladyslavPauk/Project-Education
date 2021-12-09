package org.journal.service;

import org.journal.model.Grade;
import org.journal.model.Lesson;
import org.journal.model.Student;
import org.journal.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentServiceImp implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private GroupService groupService;

    @Override
    public Student getStudent(int id) {
        return studentRepository.getStudent(id);
    }

    public Student getStudent(String email) {
        return studentRepository.getStudent(email);
    }

    @Override
    public void deleteStudent(int id) {
        studentRepository.deleteStudent(id);
    }

    @Override
    public void updateStudent(Student student, int groupId) {
        student.setGroup(groupService.getGroup(groupId));
        studentRepository.updateStudent(student);
    }

    @Override
    public void saveStudent(Student student, int groupId) {
        student.setGroup(groupService.getGroup(groupId));
        student.setGradeSet(new HashSet<Grade>());
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        studentRepository.saveStudent(student);
    }

    public Map<String, List<Grade>> getGradesPerLesson(Student student) {
        Set<Grade> grades = student.getGradeSet();
        Set<Lesson> lessons = student.getGroup().getLessonSet();
        Map<String, List<Grade>> GradesPerLesson = new HashMap<>();

        if (!grades.isEmpty()) {
            for (Grade grade : grades) {
                if (GradesPerLesson.containsKey(grade.getLesson().getName())) {
                    GradesPerLesson.get(grade.getLesson().getName()).add(grade);
                } else {
                    List<Grade> gradeList = new ArrayList<>();
                    gradeList.add(grade);
                    GradesPerLesson.put(grade.getLesson().getName(), gradeList);
                }
            }
        } else {
            for (Lesson lesson : lessons) {
                GradesPerLesson.put(lesson.getName(), new ArrayList<Grade>());
            }
        }
        return GradesPerLesson;
    }


    public Map<String, Double> getAverageGradePerLesson(Map<String, List<Grade>> lessonGradesMap) {
        Map<String, Double> averageGradePerLesson = new HashMap<>();

        for (Map.Entry<String, List<Grade>> map : lessonGradesMap.entrySet()) {
            double averageGrade = 0;
            String lessonName = map.getKey();
            List<Grade> gradeList = map.getValue();

            double sum = 0;
            if (gradeList.isEmpty()) {
                averageGradePerLesson.put(lessonName, 0.0);
            } else {
                for (Grade grade : gradeList) {
                    sum = sum + grade.getValue();
                }
                averageGrade = sum / gradeList.size();
                averageGradePerLesson.put(lessonName, averageGrade);
            }
        }
        return averageGradePerLesson;
    }

    public Map<Student, List<Grade>> getGradesPerLessonInGroup (int lessonId, int groupId) {
        Set<Student> studentsInGroup = groupService.getGroup(groupId).getStudentSet();
        Map<Student, List<Grade>> gradesPerLessonInGroup = new HashMap<>();

        for (Student student : studentsInGroup) {
            Set<Grade> grades = student.getGradeSet();
            if(grades.isEmpty()) {
                gradesPerLessonInGroup.put(student, new ArrayList<Grade>());
            }
            int count = 0;
            for (Grade grade : grades) {
                if (grade.getLesson().getId() == lessonId) {
                    if (gradesPerLessonInGroup.containsKey(grade.getStudent())) {
                        gradesPerLessonInGroup.get(grade.getStudent()).add(grade);
                    } else {
                        List<Grade> gradeList = new ArrayList<>();
                        gradeList.add(grade);
                        gradesPerLessonInGroup.put(grade.getStudent(), gradeList);
                    }
                } else {
                    count++;
                }
                if (count == grades.size()) {
                    gradesPerLessonInGroup.put(grade.getStudent(), new ArrayList<Grade>());
                }
            }
        }
        return gradesPerLessonInGroup;
    }
}
