package work.repository;

import work.model.Student;

import java.util.List;

public interface StudentRepository {
    public List<Student> getAllStudents();
    public Student getStudent(int id);
    public void deleteStudent(int id);
    public void updateStudent(Student student);
    public void setStudent(Student student);
    public List<Student> getAllStudentBySubgroupId(int subgroupId);
}
