package work.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import work.model.Teacher;
import work.repository.TeacherRepositoryImp;

import java.util.List;

@Service
public class TeacherServiceImp implements TeacherService{
    @Autowired
    private TeacherRepositoryImp teacherRepositoryImp;

    @Override
    public Teacher getTeacherById(int id) {
        return teacherRepositoryImp.getTeacherById(id);
    }

    @Override
    public void saveTeacher(Teacher teacher) {
        teacherRepositoryImp.saveTeacher(teacher);
    }

}
