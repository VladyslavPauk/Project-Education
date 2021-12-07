package org.journal.dto.mapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Generated;
import org.journal.dto.GradeDTO;
import org.journal.dto.GroupDTO;
import org.journal.dto.LessonDTO;
import org.journal.dto.StudentDTO;
import org.journal.dto.TeacherDTO;
import org.journal.model.Grade;
import org.journal.model.Group;
import org.journal.model.Lesson;
import org.journal.model.Student;
import org.journal.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-07T17:38:32+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.2 (Oracle Corporation)"
)
@Component
public class TeacherMapperImpl implements TeacherMapper {

    @Autowired
    private LessonMapper lessonMapper;
    @Autowired
    private GradeMapper gradeMapper;

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
        teacher.setGroupSet( groupDTOSetToGroupSet( teacherDTO.getGroupSet() ) );
        teacher.setLessonList( lessonDTOListToLessonList( teacherDTO.getLessonList() ) );
        teacher.setGradeList( gradeDTOListToGradeList( teacherDTO.getGradeList() ) );

        return teacher;
    }

    protected Set<Lesson> lessonDTOSetToLessonSet(Set<LessonDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<Lesson> set1 = new HashSet<Lesson>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( LessonDTO lessonDTO : set ) {
            set1.add( lessonMapper.lessonDTOtoLesson( lessonDTO ) );
        }

        return set1;
    }

    protected Set<Grade> gradeDTOSetToGradeSet(Set<GradeDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<Grade> set1 = new HashSet<Grade>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( GradeDTO gradeDTO : set ) {
            set1.add( gradeMapper.gradeDTOtoGrade( gradeDTO ) );
        }

        return set1;
    }

    protected Student studentDTOToStudent(StudentDTO studentDTO) {
        if ( studentDTO == null ) {
            return null;
        }

        Student student = new Student();

        student.setId( studentDTO.getId() );
        student.setName( studentDTO.getName() );
        student.setPassword( studentDTO.getPassword() );
        student.setEmail( studentDTO.getEmail() );
        student.setSurname( studentDTO.getSurname() );
        student.setGroup( groupDTOToGroup( studentDTO.getGroup() ) );
        student.setGradeSet( gradeDTOSetToGradeSet( studentDTO.getGradeSet() ) );

        return student;
    }

    protected Set<Student> studentDTOSetToStudentSet(Set<StudentDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<Student> set1 = new HashSet<Student>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( StudentDTO studentDTO : set ) {
            set1.add( studentDTOToStudent( studentDTO ) );
        }

        return set1;
    }

    protected Group groupDTOToGroup(GroupDTO groupDTO) {
        if ( groupDTO == null ) {
            return null;
        }

        Group group = new Group();

        group.setLessonSet( lessonDTOSetToLessonSet( groupDTO.getLessonSet() ) );
        group.setTeacher( teacherDTOtoTeacher( groupDTO.getTeacher() ) );
        group.setId( groupDTO.getId() );
        group.setName( groupDTO.getName() );
        group.setStudentSet( studentDTOSetToStudentSet( groupDTO.getStudentSet() ) );

        return group;
    }

    protected Set<Group> groupDTOSetToGroupSet(Set<GroupDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<Group> set1 = new HashSet<Group>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( GroupDTO groupDTO : set ) {
            set1.add( groupDTOToGroup( groupDTO ) );
        }

        return set1;
    }

    protected List<Lesson> lessonDTOListToLessonList(List<LessonDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Lesson> list1 = new ArrayList<Lesson>( list.size() );
        for ( LessonDTO lessonDTO : list ) {
            list1.add( lessonMapper.lessonDTOtoLesson( lessonDTO ) );
        }

        return list1;
    }

    protected List<Grade> gradeDTOListToGradeList(List<GradeDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Grade> list1 = new ArrayList<Grade>( list.size() );
        for ( GradeDTO gradeDTO : list ) {
            list1.add( gradeMapper.gradeDTOtoGrade( gradeDTO ) );
        }

        return list1;
    }
}
