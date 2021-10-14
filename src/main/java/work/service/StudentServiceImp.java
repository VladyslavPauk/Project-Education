package work.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import work.model.Student;
import work.repository.StudentRepositoryImp;
import java.util.List;

@Service
public class StudentServiceImp implements StudentService {
    @Autowired
    private StudentRepositoryImp studentsRepositoryImp;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public List<Student> getAllStudents() {
        return studentsRepositoryImp.getAllStudents();
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
    public void updateStudent(Student student) {
        studentsRepositoryImp.updateStudent(student);
    }

    @Override
    public void setStudent(Student student) {
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        studentsRepositoryImp.setStudent(student);
    }

    @Override
    public List<Student> getAllStudentBySubgroupId(int subgroupId) {
        return studentsRepositoryImp.getAllStudentBySubgroupId(subgroupId);
    }
}
