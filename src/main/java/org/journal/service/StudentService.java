package org.journal.service;

import org.journal.model.Grade;
import org.journal.model.Group;
import org.journal.model.Lesson;
import org.journal.model.Student;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface StudentService {

    Student getStudent(int id);

    Student getStudent(String email);

    void deleteStudent(int id);

    void updateStudent(Student student, int groupId, int studentId);

    void saveStudent(Student student, int groupId);

    Map<String, List<Grade>> getGradesPerLesson(Student student);

    Map<String, Double> getAverageGradePerLesson(Map<String, List<Grade>> lessonGradesMap);

    Map<Student, List<Grade>> getGradesPerLessonInGroup (int lessonId, int groupId);
}
