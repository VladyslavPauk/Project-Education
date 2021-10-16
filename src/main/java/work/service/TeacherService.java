package work.service;

import work.model.Teacher;

import java.util.List;

public interface TeacherService {
    public Teacher getTeacherById(int id);
    public void saveTeacher(Teacher teacher);
}
