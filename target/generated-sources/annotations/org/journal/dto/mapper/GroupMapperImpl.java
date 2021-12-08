package org.journal.dto.mapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Generated;
import org.journal.dto.GroupDTO;
import org.journal.dto.StudentDTO;
import org.journal.model.Group;
import org.journal.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-08T21:05:21+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.2 (Oracle Corporation)"
)
@Component
public class GroupMapperImpl implements GroupMapper {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public GroupDTO toGroupDTO(Group group) {
        if ( group == null ) {
            return null;
        }

        GroupDTO groupDTO = new GroupDTO();

        groupDTO.setStudentSet( studentSetToStudentDTOSet( group.getStudentSet() ) );
        groupDTO.setId( group.getId() );
        groupDTO.setName( group.getName() );
        groupDTO.setTeacher( teacherMapper.toTeacherDTO( group.getTeacher() ) );

        return groupDTO;
    }

    @Override
    public GroupDTO toGroupDTOWithoutEntity(Group group) {
        if ( group == null ) {
            return null;
        }

        GroupDTO groupDTO = new GroupDTO();

        groupDTO.setId( group.getId() );
        groupDTO.setName( group.getName() );

        return groupDTO;
    }

    @Override
    public List<GroupDTO> toGroupDtoList(List<Group> groups) {
        if ( groups == null ) {
            return null;
        }

        List<GroupDTO> list = new ArrayList<GroupDTO>( groups.size() );
        for ( Group group : groups ) {
            list.add( toGroupDTOWithoutEntity( group ) );
        }

        return list;
    }

    protected Set<StudentDTO> studentSetToStudentDTOSet(Set<Student> set) {
        if ( set == null ) {
            return null;
        }

        Set<StudentDTO> set1 = new HashSet<StudentDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Student student : set ) {
            set1.add( studentMapper.toStudentDTOWithoutEntity( student ) );
        }

        return set1;
    }
}
