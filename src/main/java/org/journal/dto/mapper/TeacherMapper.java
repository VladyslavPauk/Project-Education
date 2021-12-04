package org.journal.dto.mapper;

import org.journal.dto.TeacherDTO;
import org.journal.model.Teacher;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TeacherMapper {
    TeacherMapper TEACHER_MAPPER = Mappers.getMapper(TeacherMapper.class);

    TeacherDTO toTeacherDTO(Teacher teacher);
    @InheritInverseConfiguration
    Teacher teacherDTOtoTeacher(TeacherDTO teacherDTO);
}
