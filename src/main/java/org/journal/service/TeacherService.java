package org.journal.service;

import org.journal.model.Group;
import org.journal.model.Lesson;
import org.journal.model.Teacher;

import java.util.Map;
import java.util.Set;


public interface TeacherService {
    Teacher getTeacher(int id);

    Teacher getTeacher(String email);

    void saveTeacher(Teacher teacher, int[] subgroupsId);

    void deleteTeacher(Teacher teacher);

    void updateTeacher(Teacher teacher);

    Map<Group, Set<Lesson>> getLessonsPerGroup(Teacher teacher);
}
