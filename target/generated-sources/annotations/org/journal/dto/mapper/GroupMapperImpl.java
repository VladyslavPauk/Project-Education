package org.journal.dto.mapper;

import java.util.HashSet;
import java.util.Set;
import javax.annotation.Generated;
import org.journal.dto.GroupDTO;
import org.journal.model.Group;
import org.journal.model.Lesson;
import org.journal.model.Student;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-04T20:28:13+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.2 (Oracle Corporation)"
)
public class GroupMapperImpl implements GroupMapper {

    @Override
    public GroupDTO toGroupDTO(Group group) {
        if ( group == null ) {
            return null;
        }

        GroupDTO groupDTO = new GroupDTO();

        groupDTO.setId( group.getId() );
        groupDTO.setName( group.getName() );
        Set<Student> set = group.getStudentSet();
        if ( set != null ) {
            groupDTO.setStudentSet( new HashSet<Student>( set ) );
        }
        groupDTO.setTeacher( group.getTeacher() );
        Set<Lesson> set1 = group.getLessonSet();
        if ( set1 != null ) {
            groupDTO.setLessonSet( new HashSet<Lesson>( set1 ) );
        }

        return groupDTO;
    }

    @Override
    public Group groupDTOtoGroup(GroupDTO groupDTO) {
        if ( groupDTO == null ) {
            return null;
        }

        Group group = new Group();

        Set<Lesson> set = groupDTO.getLessonSet();
        if ( set != null ) {
            group.setLessonSet( new HashSet<Lesson>( set ) );
        }
        group.setTeacher( groupDTO.getTeacher() );
        group.setId( groupDTO.getId() );
        group.setName( groupDTO.getName() );
        Set<Student> set1 = groupDTO.getStudentSet();
        if ( set1 != null ) {
            group.setStudentSet( new HashSet<Student>( set1 ) );
        }

        return group;
    }
}
