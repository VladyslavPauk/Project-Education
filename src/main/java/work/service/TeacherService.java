package work.service;

import work.model.Teacher;


public interface TeacherService {
    Teacher getTeacher(int id);

    void saveTeacher(Teacher teacher, int[] subgroupsId);

    void deleteTeacher(Teacher teacher);

    void updateTeacher(Teacher teacher, int teacherId);
}
