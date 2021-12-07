package org.journal.dto.mapper;

import java.util.HashSet;
import java.util.Set;
import javax.annotation.Generated;
import org.journal.dto.GradeDTO;
import org.journal.dto.GroupDTO;
import org.journal.dto.LessonDTO;
import org.journal.dto.StudentDTO;
import org.journal.model.Grade;
import org.journal.model.Group;
import org.journal.model.Lesson;
import org.journal.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-07T17:38:32+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.2 (Oracle Corporation)"
)
@Component
public class LessonMapperImpl implements LessonMapper {

    @Autowired
    private GroupMapper groupMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private GradeMapper gradeMapper;

    @Override
    public LessonDTO toLessonDTO(Lesson lesson) {
        if ( lesson == null ) {
            return null;
        }

        LessonDTO lessonDTO = new LessonDTO();

        lessonDTO.setId( lesson.getId() );
        lessonDTO.setName( lesson.getName() );
        lessonDTO.setGroup( groupMapper.toGroupDTO( lesson.getGroup() ) );
        lessonDTO.setTeacher( teacherMapper.toTeacherDTO( lesson.getTeacher() ) );

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
        lesson.setGroup( groupDTOToGroup( lessonDTO.getGroup() ) );
        lesson.setTeacher( teacherMapper.teacherDTOtoTeacher( lessonDTO.getTeacher() ) );
        lesson.setGradeSet( gradeDTOSetToGradeSet( lessonDTO.getGradeSet() ) );

        return lesson;
    }

    protected Set<Lesson> lessonDTOSetToLessonSet(Set<LessonDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<Lesson> set1 = new HashSet<Lesson>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( LessonDTO lessonDTO : set ) {
            set1.add( lessonDTOtoLesson( lessonDTO ) );
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
        group.setTeacher( teacherMapper.teacherDTOtoTeacher( groupDTO.getTeacher() ) );
        group.setId( groupDTO.getId() );
        group.setName( groupDTO.getName() );
        group.setStudentSet( studentDTOSetToStudentSet( groupDTO.getStudentSet() ) );

        return group;
    }
}
