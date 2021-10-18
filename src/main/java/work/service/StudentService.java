package work.service;

import work.model.Student;

import java.util.List;

public interface StudentService {
    public List<Student> getAllStudents();

    public Student getStudent(int id);

    public void deleteStudent(int id);

    public void updateStudent(Student student);

    public void setStudent(Student student);

}
