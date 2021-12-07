package org.journal.dto.mapper;

import org.journal.dto.TeacherDTO;
import org.journal.model.Teacher;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {GroupMapper.class, LessonMapper.class, GradeMapper.class})
public interface TeacherMapper {
    TeacherMapper TEACHER_MAPPER = Mappers.getMapper(TeacherMapper.class);

    @Mappings({
            @Mapping(target = "groupSet", ignore = true),
            @Mapping(target = "lessonList", ignore = true),
            @Mapping(target = "gradeList", ignore = true)
    })
    TeacherDTO toTeacherDTO(Teacher teacher);
    @InheritInverseConfiguration
    Teacher teacherDTOtoTeacher(TeacherDTO teacherDTO);
}
