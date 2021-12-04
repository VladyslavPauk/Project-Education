package org.journal.dto.mapper;

import org.journal.dto.GradeDTO;
import org.journal.model.Grade;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface GradeMapper {
    GradeMapper GRADE_MAPPER = Mappers.getMapper(GradeMapper.class);

    GradeDTO toGradeDTO(Grade grade);

    @InheritInverseConfiguration
    Grade gradeDTOtoGrade(GradeDTO gradeDTO);
}
