package org.journal.dto.mapper;

import org.journal.dto.GroupDTO;
import org.journal.dto.LessonDTO;
import org.journal.dto.TeacherDTO;
import org.journal.model.Group;
import org.journal.model.Lesson;
import org.journal.model.Teacher;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.Map;
import java.util.Set;

@Mapper(componentModel = "spring", uses = {GroupMapper.class, LessonMapper.class, GradeMapper.class})
public interface TeacherMapper {
    TeacherMapper TEACHER_MAPPER = Mappers.getMapper(TeacherMapper.class);

    @Mappings({
            @Mapping(target = "groupSet", ignore = true),
            @Mapping(target = "lessonList", ignore = true),
            @Mapping(target = "gradeList", ignore = true)
    })
    TeacherDTO toTeacherDTO(Teacher teacher);

    @MapMapping(keyQualifiedByName = "toGroupDTOWithoutEntity")
    Map<GroupDTO, Set<LessonDTO>> toLessonsPerGroupDTO(Map<Group, Set<Lesson>> map);

    @Mappings({
            @Mapping(target = "groupSet", ignore = true),
            @Mapping(target = "lessonList", ignore = true),
            @Mapping(target = "gradeList", ignore = true)
    })
    Teacher teacherDTotoTeacher(TeacherDTO teacherDTO);
}
