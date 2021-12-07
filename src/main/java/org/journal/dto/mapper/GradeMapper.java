package org.journal.dto.mapper;

import org.journal.dto.GradeDTO;
import org.journal.model.Grade;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {LessonMapper.class, StudentMapper.class, TeacherMapper.class})
public interface GradeMapper {
    GradeMapper GRADE_MAPPER = Mappers.getMapper(GradeMapper.class);

    GradeDTO toGradeDTO(Grade grade);

    @InheritInverseConfiguration
    Grade gradeDTOtoGrade(GradeDTO gradeDTO);
}
