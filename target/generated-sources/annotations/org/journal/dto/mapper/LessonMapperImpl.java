package org.journal.dto.mapper;

import java.util.HashSet;
import java.util.Set;
import javax.annotation.Generated;
import org.journal.dto.LessonDTO;
import org.journal.model.Grade;
import org.journal.model.Lesson;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-04T20:28:13+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.2 (Oracle Corporation)"
)
public class LessonMapperImpl implements LessonMapper {

    @Override
    public LessonDTO toLessonDTO(Lesson lesson) {
        if ( lesson == null ) {
            return null;
        }

        LessonDTO lessonDTO = new LessonDTO();

        lessonDTO.setId( lesson.getId() );
        lessonDTO.setName( lesson.getName() );
        lessonDTO.setGroup( lesson.getGroup() );
        lessonDTO.setTeacher( lesson.getTeacher() );
        Set<Grade> set = lesson.getGradeSet();
        if ( set != null ) {
            lessonDTO.setGradeSet( new HashSet<Grade>( set ) );
        }

        return lessonDTO;
    }

    @Override
    public Lesson lessonDTOtoLesson(LessonDTO lessonDTO) {
        if ( lessonDTO == null ) {
            return null;
        }

        Lesson lesson = new Lesson();

        lesson.setId( lessonDTO.getId() );
        lesson.setName( lessonDTO.getName() );
        lesson.setGroup( lessonDTO.getGroup() );
        lesson.setTeacher( lessonDTO.getTeacher() );
        Set<Grade> set = lessonDTO.getGradeSet();
        if ( set != null ) {
            lesson.setGradeSet( new HashSet<Grade>( set ) );
        }

        return lesson;
    }
}
