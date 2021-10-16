package work.repository;

import work.model.Teacher;

import java.util.List;

public interface TeacherRepository {
    public Teacher getTeacherById(int id);
    public void saveTeacher(Teacher teacher);
}
