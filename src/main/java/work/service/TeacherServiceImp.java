package work.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import work.model.Lesson;
import work.model.Student;
import work.model.Subgroup;
import work.model.Teacher;
import work.repository.TeacherRepositoryImp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


@Service
public class TeacherServiceImp implements TeacherService {
    @Autowired
    private TeacherRepositoryImp teacherRepositoryImp;

    @Override
    public Teacher getTeacherById(int id) {
        return teacherRepositoryImp.getTeacherById(id);
    }

    @Override
    public void saveTeacher(Teacher teacher) {
        teacherRepositoryImp.saveTeacher(teacher);
    }

    @Override
    public void deleteTeacher(Teacher teacher) {
        teacherRepositoryImp.deleteTeacher(teacher);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        teacherRepositoryImp.updateTeacher(teacher);
    }

    public Map<Subgroup, Set<Lesson>> getSubgroupLessonSetMap(Set<Subgroup> subgroups) {
        Map<Subgroup, Set<Lesson>> subgroupLessonSetMap = new HashMap<>();
        for(Subgroup subgroup: subgroups) {
            subgroupLessonSetMap.put(subgroup,subgroup.getLessonSet());
        }
        return subgroupLessonSetMap;
    }

}
