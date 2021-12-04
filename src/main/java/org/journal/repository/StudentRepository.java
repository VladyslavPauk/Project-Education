package org.journal.repository;

import org.journal.model.Student;

import java.util.List;

public interface StudentRepository {

    Student getStudent(int id);

    Student getStudent(String email);

    void deleteStudent(int id);

    void updateStudent(Student student);

    void saveStudent(Student student);

}
