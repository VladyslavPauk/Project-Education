package work.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import work.model.Grade;
import work.model.Lesson;
import work.model.Subgroup;
import work.model.Teacher;
import work.repository.TeacherRepositoryImp;
import java.util.*;


@Service
public class TeacherServiceImp implements TeacherService {
    @Autowired
    private TeacherRepositoryImp teacherRepositoryImp;
    @Autowired
    private SubgroupServiceImp subgroupServiceImp;

    @Override
    public Teacher getTeacher(int id) {
        return teacherRepositoryImp.getTeacher(id);
    }

    @Override
    public void saveTeacher(Teacher teacher, int [] subgroupsId) {
        Set<Subgroup> subgroupSet = new HashSet<>();
        for (int i : subgroupsId) {
            subgroupSet.add(subgroupServiceImp.getSubgroup(i));
        }
        teacher.setSubgroupSet(subgroupSet);
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

    public Map<Subgroup, Set<Lesson>> getSubgroupLessonsMap(Set<Subgroup> subgroups) {
        Map<Subgroup, Set<Lesson>> subgroupLessonsMap = new HashMap<>();
        for(Subgroup subgroup: subgroups) {
            subgroupLessonsMap.put(subgroup, subgroup.getLessonSet());
        }
        return subgroupLessonsMap;
    }
}
