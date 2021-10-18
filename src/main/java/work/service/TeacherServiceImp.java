package work.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import work.model.Teacher;
import work.repository.TeacherRepositoryImp;


@Service
public class TeacherServiceImp implements TeacherService {
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

    @Override
    public void deleteTeacher(Teacher teacher) {
        teacherRepositoryImp.deleteTeacher(teacher);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        teacherRepositoryImp.updateTeacher(teacher);
    }

}
