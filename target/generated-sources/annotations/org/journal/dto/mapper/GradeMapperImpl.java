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
public class GradeMapperImpl implements GradeMapper {

    @Autowired
    private LessonMapper lessonMapper;
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public GradeDTO toGradeDTO(Grade grade) {
        if ( grade == null ) {
            return null;
        }

        GradeDTO gradeDTO = new GradeDTO();

        gradeDTO.setId( grade.getId() );
        gradeDTO.setValue( grade.getValue() );
        gradeDTO.setLesson( lessonMapper.toLessonDTO( grade.getLesson() ) );
        gradeDTO.setStudent( studentToStudentDTO( grade.getStudent() ) );
        gradeDTO.setTeacher( teacherMapper.toTeacherDTO( grade.getTeacher() ) );

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
        grade.setLesson( lessonMapper.lessonDTOtoLesson( gradeDTO.getLesson() ) );
        grade.setStudent( studentDTOToStudent( gradeDTO.getStudent() ) );
        grade.setTeacher( teacherMapper.teacherDTOtoTeacher( gradeDTO.getTeacher() ) );

        return grade;
    }

    protected Set<StudentDTO> studentSetToStudentDTOSet(Set<Student> set) {
        if ( set == null ) {
            return null;
        }

        Set<StudentDTO> set1 = new HashSet<StudentDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Student student : set ) {
            set1.add( studentToStudentDTO( student ) );
        }

        return set1;
    }

    protected Set<LessonDTO> lessonSetToLessonDTOSet(Set<Lesson> set) {
        if ( set == null ) {
            return null;
        }

        Set<LessonDTO> set1 = new HashSet<LessonDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Lesson lesson : set ) {
            set1.add( lessonMapper.toLessonDTO( lesson ) );
        }

        return set1;
    }

    protected GroupDTO groupToGroupDTO(Group group) {
        if ( group == null ) {
            return null;
        }

        GroupDTO groupDTO = new GroupDTO();

        groupDTO.setId( group.getId() );
        groupDTO.setName( group.getName() );
        groupDTO.setStudentSet( studentSetToStudentDTOSet( group.getStudentSet() ) );
        groupDTO.setTeacher( teacherMapper.toTeacherDTO( group.getTeacher() ) );
        groupDTO.setLessonSet( lessonSetToLessonDTOSet( group.getLessonSet() ) );

        return groupDTO;
    }

    protected Set<GradeDTO> gradeSetToGradeDTOSet(Set<Grade> set) {
        if ( set == null ) {
            return null;
        }

        Set<GradeDTO> set1 = new HashSet<GradeDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Grade grade : set ) {
            set1.add( toGradeDTO( grade ) );
        }

        return set1;
    }

    protected StudentDTO studentToStudentDTO(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentDTO studentDTO = new StudentDTO();

        studentDTO.setId( student.getId() );
        studentDTO.setName( student.getName() );
        studentDTO.setPassword( student.getPassword() );
        studentDTO.setEmail( student.getEmail() );
        studentDTO.setSurname( student.getSurname() );
        studentDTO.setGroup( groupToGroupDTO( student.getGroup() ) );
        studentDTO.setGradeSet( gradeSetToGradeDTOSet( student.getGradeSet() ) );

        return studentDTO;
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

    protected Set<Grade> gradeDTOSetToGradeSet(Set<GradeDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<Grade> set1 = new HashSet<Grade>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( GradeDTO gradeDTO : set ) {
            set1.add( gradeDTOtoGrade( gradeDTO ) );
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
}
