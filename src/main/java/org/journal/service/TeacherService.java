package org.journal.service;

import org.journal.model.Teacher;


public interface TeacherService {
    Teacher getTeacher(int id);

    void saveTeacher(Teacher teacher, int[] subgroupsId);

    void deleteTeacher(Teacher teacher);

    void updateTeacher(Teacher teacher, int teacherId);
}
