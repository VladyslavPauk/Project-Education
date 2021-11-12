package org.journal.service;

import org.journal.model.Grade;
import org.journal.model.Student;
import org.journal.model.Subgroup;

import java.util.HashSet;
import java.util.List;

public interface StudentService {
    List<Student> getStudents();

    Student getStudent(int id);

    void deleteStudent(int id);

    void updateStudent(Student student, Subgroup subgroup, int studentId);

    void saveStudent(Student student, Subgroup subgroup, HashSet<Grade> grades);

}
