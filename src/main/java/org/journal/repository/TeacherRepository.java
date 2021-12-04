package org.journal.repository;

import org.journal.model.Teacher;


public interface TeacherRepository {
    Teacher getTeacher(int id);

    Teacher getTeacher(String email);

    void saveTeacher(Teacher teacher);

    void deleteTeacher(Teacher teacher);

    void updateTeacher(Teacher teacher);
}
