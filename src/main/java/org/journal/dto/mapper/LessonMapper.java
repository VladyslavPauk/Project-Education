package org.journal.dto.mapper;

import org.journal.dto.LessonDTO;
import org.journal.model.Lesson;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LessonMapper {
    LessonMapper LESSON_MAPPER = Mappers.getMapper(LessonMapper.class);

    LessonDTO toLessonDTO(Lesson lesson);
    @InheritInverseConfiguration
    Lesson lessonDTOtoLesson(LessonDTO lessonDTO);
}
