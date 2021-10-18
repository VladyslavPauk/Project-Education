package work.repository;

import work.model.Teacher;


public interface TeacherRepository {
    public Teacher getTeacherById(int id);

    public void saveTeacher(Teacher teacher);

    public void deleteTeacher(Teacher teacher);

    public void updateTeacher(Teacher teacher);
}
