package org.journal.dto.mapper;

import org.journal.dto.GradeDTO;
import org.journal.dto.LessonDTO;
import org.journal.dto.StudentDTO;
import org.journal.model.Grade;
import org.journal.model.Lesson;
import org.journal.model.Student;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Mapper(componentModel = "spring", uses = {GroupMapper.class, GradeMapper.class, StudentMapper.class})
public interface LessonMapper {
    LessonMapper LESSON_MAPPER = Mappers.getMapper(LessonMapper.class);

    @Named("toLessonDTO")
    @Mappings({
            @Mapping(target = "gradeSet", ignore = true),
            @Mapping(target = "group", ignore = true),
            @Mapping(target = "teacher", ignore = true)
    })
    LessonDTO toLessonDTO(Lesson lesson);

    @IterableMapping(qualifiedByName = "toLessonDTO")
    Set<LessonDTO> toLessonDTOSet(Set<Lesson> lessonSet);
}
