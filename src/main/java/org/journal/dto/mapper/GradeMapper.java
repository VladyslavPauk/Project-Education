package org.journal.dto.mapper;

import org.journal.dto.GradeDTO;
import org.journal.model.Grade;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Map;

@Mapper(componentModel = "spring", uses = {LessonMapper.class, StudentMapper.class, TeacherMapper.class})
public interface GradeMapper {
    GradeMapper GRADE_MAPPER = Mappers.getMapper(GradeMapper.class);


    @IterableMapping(qualifiedByName = "toGradeDtoWithoutEntity")
    List<GradeDTO> toGradeDToList(List<Grade> gradeList);

    @Named("toGradeDtoWithoutEntity")
    @Mappings({
            @Mapping(target = "lesson", ignore = true),
            @Mapping(target = "teacher", ignore = true),
            @Mapping(target = "student", ignore = true)
    })
    GradeDTO toGradeDtoWithoutEntity(Grade grade);

}
