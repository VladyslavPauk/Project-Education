package org.journal.dto.mapper;

import javax.annotation.Generated;
import org.journal.dto.GradeDTO;
import org.journal.model.Grade;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-04T20:28:13+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.2 (Oracle Corporation)"
)
@Component
public class GradeMapperImpl implements GradeMapper {

    @Override
    public GradeDTO toGradeDTO(Grade grade) {
        if ( grade == null ) {
            return null;
        }

        GradeDTO gradeDTO = new GradeDTO();

        gradeDTO.setId( grade.getId() );
        gradeDTO.setValue( grade.getValue() );
        gradeDTO.setLesson( grade.getLesson() );
        gradeDTO.setStudent( grade.getStudent() );
        gradeDTO.setTeacher( grade.getTeacher() );

        return gradeDTO;
    }

    @Override
    public Grade gradeDTOtoGrade(GradeDTO gradeDTO) {
        if ( gradeDTO == null ) {
            return null;
        }

        Grade grade = new Grade();

        grade.setId( gradeDTO.getId() );
        grade.setValue( gradeDTO.getValue() );
        grade.setLesson( gradeDTO.getLesson() );
        grade.setStudent( gradeDTO.getStudent() );
        grade.setTeacher( gradeDTO.getTeacher() );

        return grade;
    }
}
