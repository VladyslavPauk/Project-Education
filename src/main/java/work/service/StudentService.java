package work.service;

import work.model.Grade;
import work.model.Student;
import work.model.Subgroup;

import java.util.HashSet;
import java.util.List;

public interface StudentService {
    List<Student> getStudents();

    Student getStudent(int id);

    void deleteStudent(int id);

    void updateStudent(Student student, Subgroup subgroup, int studentId);

    void saveStudent(Student student, Subgroup subgroup, HashSet<Grade> grades);

}
