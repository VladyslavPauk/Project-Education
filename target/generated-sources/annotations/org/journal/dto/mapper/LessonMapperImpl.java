package org.journal.dto.mapper;

import java.util.HashSet;
import java.util.Set;
import javax.annotation.Generated;
import org.journal.dto.LessonDTO;
import org.journal.model.Lesson;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-08T21:05:21+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.2 (Oracle Corporation)"
)
@Component
public class LessonMapperImpl implements LessonMapper {

    @Override
    public LessonDTO toLessonDTO(Lesson lesson) {
        if ( lesson == null ) {
            return null;
        }

        LessonDTO lessonDTO = new LessonDTO();

        lessonDTO.setId( lesson.getId() );
        lessonDTO.setName( lesson.getName() );

        return lessonDTO;
    }

    @Override
    public Set<LessonDTO> toLessonDTOSet(Set<Lesson> lessonSet) {
        if ( lessonSet == null ) {
            return null;
        }

        Set<LessonDTO> set = new HashSet<LessonDTO>( Math.max( (int) ( lessonSet.size() / .75f ) + 1, 16 ) );
        for ( Lesson lesson : lessonSet ) {
            set.add( toLessonDTO( lesson ) );
        }

        return set;
    }
}
