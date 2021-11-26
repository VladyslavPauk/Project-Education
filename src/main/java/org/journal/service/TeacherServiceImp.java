package org.journal.service;

import org.journal.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.journal.model.Grade;
import org.journal.model.Lesson;
import org.journal.model.Teacher;
import org.journal.repository.TeacherRepositoryImp;
import java.util.*;


@Service
public class TeacherServiceImp implements TeacherService {
    @Autowired
    private TeacherRepositoryImp teacherRepositoryImp;
    @Autowired
    private GroupServiceImp groupServiceImp;

    @Override
    public Teacher getTeacher(int id) {
        return teacherRepositoryImp.getTeacher(id);
    }

    @Override
    public void saveTeacher(Teacher teacher, int [] groupsId) {
        Set<Group> groupSet = new HashSet<>();
        for (int i : groupsId) {
            groupSet.add(groupServiceImp.getGroup(i));
        }
        teacher.setGroupSet(groupSet);
        teacher.setLessonList(new ArrayList<Lesson>());
        teacher.setGradeList(new ArrayList<Grade>());
        teacherRepositoryImp.saveTeacher(teacher);
    }

    @Override
    public void deleteTeacher(Teacher teacher) {
        teacherRepositoryImp.deleteTeacher(teacher);
    }

    @Override
    public void updateTeacher(Teacher teacher, int teacherId) {
        teacher.setId(teacherId);
        teacherRepositoryImp.updateTeacher(teacher);
    }

    public Map<Group, Set<Lesson>> getGroupLessonsMap(Set<Group> groups) {
        Map<Group, Set<Lesson>> groupLessonsMap = new HashMap<>();
        for(Group group : groups) {
            groupLessonsMap.put(group, group.getLessonSet());
        }
        return groupLessonsMap;
    }
}
