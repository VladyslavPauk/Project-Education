package work.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import work.model.Student;
import work.repository.StudentRepositoryImp;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StudentServiceImp implements StudentService{
    @Autowired
    StudentRepositoryImp studentsRepositoryImp;

    @Override
    @Transactional
    public List<Student> getAllStudents() {
       return studentsRepositoryImp.getAllStudents();
    }

    @Override
    @Transactional
    public Student getStudent(int id) {
        return studentsRepositoryImp.getStudent(id);
    }

    @Override
    @Transactional
    public void deleteStudent(int id) {
        studentsRepositoryImp.deleteStudent(id);
    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
        studentsRepositoryImp.updateStudent(student);
    }

    @Override
    @Transactional
    public void setStudent(Student student) {
        studentsRepositoryImp.setStudent(student);
    }
}
