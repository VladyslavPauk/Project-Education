package org.journal.service;

import org.journal.model.Grade;
import org.journal.model.Group;
import org.journal.model.Student;

import java.util.HashSet;
import java.util.List;

public interface StudentService {
    List<Student> getStudents();

    Student getStudent(int id);

    void deleteStudent(int id);

    void updateStudent(Student student, Group group, int studentId);

    void saveStudent(Student student, Group group, HashSet<Grade> grades);

}
