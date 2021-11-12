package org.journal.repository;

import org.journal.model.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> getStudents();

    Student getStudent(int id);

    void deleteStudent(int id);

    void updateStudent(Student student);

    void saveStudent(Student student);

}
