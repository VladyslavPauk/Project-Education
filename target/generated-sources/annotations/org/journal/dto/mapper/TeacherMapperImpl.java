package org.journal.dto.mapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Generated;
import org.journal.dto.TeacherDTO;
import org.journal.model.Grade;
import org.journal.model.Group;
import org.journal.model.Lesson;
import org.journal.model.Teacher;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-04T20:28:13+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.2 (Oracle Corporation)"
)
public class TeacherMapperImpl implements TeacherMapper {

    @Override
    public TeacherDTO toTeacherDTO(Teacher teacher) {
        if ( teacher == null ) {
            return null;
        }

        TeacherDTO teacherDTO = new TeacherDTO();

        teacherDTO.setId( teacher.getId() );
        teacherDTO.setName( teacher.getName() );
        teacherDTO.setSurname( teacher.getSurname() );
        teacherDTO.setEmail( teacher.getEmail() );
        teacherDTO.setPassword( teacher.getPassword() );
        Set<Group> set = teacher.getGroupSet();
        if ( set != null ) {
            teacherDTO.setGroupSet( new HashSet<Group>( set ) );
        }
        List<Lesson> list = teacher.getLessonList();
        if ( list != null ) {
            teacherDTO.setLessonList( new ArrayList<Lesson>( list ) );
        }
        List<Grade> list1 = teacher.getGradeList();
        if ( list1 != null ) {
            teacherDTO.setGradeList( new ArrayList<Grade>( list1 ) );
        }

        return teacherDTO;
    }

    @Override
    public Teacher teacherDTOtoTeacher(TeacherDTO teacherDTO) {
        if ( teacherDTO == null ) {
            return null;
        }

        Teacher teacher = new Teacher();

        teacher.setId( teacherDTO.getId() );
        teacher.setName( teacherDTO.getName() );
        teacher.setSurname( teacherDTO.getSurname() );
        teacher.setEmail( teacherDTO.getEmail() );
        teacher.setPassword( teacherDTO.getPassword() );
        Set<Group> set = teacherDTO.getGroupSet();
        if ( set != null ) {
            teacher.setGroupSet( new HashSet<Group>( set ) );
        }
        List<Lesson> list = teacherDTO.getLessonList();
        if ( list != null ) {
            teacher.setLessonList( new ArrayList<Lesson>( list ) );
        }
        List<Grade> list1 = teacherDTO.getGradeList();
        if ( list1 != null ) {
            teacher.setGradeList( new ArrayList<Grade>( list1 ) );
        }

        return teacher;
    }
}
