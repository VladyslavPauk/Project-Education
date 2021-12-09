package org.journal.dto.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.journal.dto.GradeDTO;
import org.journal.model.Grade;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-09T16:47:10+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.2 (Oracle Corporation)"
)
@Component
public class GradeMapperImpl implements GradeMapper {

    @Override
    public List<GradeDTO> toGradeDToList(List<Grade> gradeList) {
        if ( gradeList == null ) {
            return null;
        }

        List<GradeDTO> list = new ArrayList<GradeDTO>( gradeList.size() );
        for ( Grade grade : gradeList ) {
            list.add( toGradeDtoWithoutEntity( grade ) );
        }

        return list;
    }

    @Override
    public GradeDTO toGradeDtoWithoutEntity(Grade grade) {
        if ( grade == null ) {
            return null;
        }

        GradeDTO gradeDTO = new GradeDTO();

        gradeDTO.setId( grade.getId() );
        gradeDTO.setValue( grade.getValue() );

        return gradeDTO;
    }
}
