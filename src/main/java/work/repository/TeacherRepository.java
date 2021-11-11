package work.repository;

import work.model.Teacher;


public interface TeacherRepository {
    Teacher getTeacher(int id);

    void saveTeacher(Teacher teacher);

    void deleteTeacher(Teacher teacher);

    void updateTeacher(Teacher teacher);
}
