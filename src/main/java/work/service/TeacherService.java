package work.service;

import work.model.Teacher;


public interface TeacherService {
    public Teacher getTeacherById(int id);

    public void saveTeacher(Teacher teacher);

    public void deleteTeacher(Teacher teacher);

    public void  updateTeacher(Teacher teacher);
}
