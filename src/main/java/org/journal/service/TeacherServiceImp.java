package org.journal.service;

import org.journal.model.Group;
import org.journal.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.journal.model.Grade;
import org.journal.model.Lesson;
import org.journal.model.Teacher;
import java.util.*;


@Service
public class TeacherServiceImp implements TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private GroupService groupService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Teacher getTeacher(int id) {
        return teacherRepository.getTeacher(id);
    }

    @Override
    public Teacher getTeacher(String email) {
       return teacherRepository.getTeacher(email);
    }

    @Override
    public void saveTeacher(Teacher teacher, int [] groupsId) {
        Set<Group> groupSet = new HashSet<>();
        for (int i : groupsId) {
            groupSet.add(groupService.getGroup(i));
        }
        teacher.setGroupSet(groupSet);
        teacher.setLessonList(new ArrayList<Lesson>());
        teacher.setGradeList(new ArrayList<Grade>());
        teacher.setPassword(passwordEncoder.encode(teacher.getPassword()));
        teacherRepository.saveTeacher(teacher);
    }

    @Override
    public void deleteTeacher(Teacher teacher) {
        teacherRepository.deleteTeacher(teacher);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        teacherRepository.updateTeacher(teacher);
    }

    public Map<Group, Set<Lesson>> getLessonsPerGroup(Teacher teacher) {
        Set<Group> groups = teacher.getGroupSet();
        Map<Group, Set<Lesson>> groupLessonsMap = new HashMap<>();
        for(Group group : groups) {
            groupLessonsMap.put(group, group.getLessonSet());
        }
        return groupLessonsMap;
    }

}
