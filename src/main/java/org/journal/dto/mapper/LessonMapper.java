package org.journal.dto.mapper;

import org.journal.dto.LessonDTO;
import org.journal.model.Lesson;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {GroupMapper.class, TeacherMapper.class, GradeMapper.class})
public interface LessonMapper {
    LessonMapper LESSON_MAPPER = Mappers.getMapper(LessonMapper.class);

    @Mapping(target = "gradeSet", ignore = true)
    LessonDTO toLessonDTO(Lesson lesson);
    @InheritInverseConfiguration
    Lesson lessonDTOtoLesson(LessonDTO lessonDTO);
}
