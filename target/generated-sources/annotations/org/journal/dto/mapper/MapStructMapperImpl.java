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
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-04T20:26:30+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.2 (Oracle Corporation)"
)
@Component
public class MapStructMapperImpl implements MapStructMapper {

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

    @Override
    public StudentDTO toStudentDTO(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentDTO studentDTO = new StudentDTO();

        studentDTO.setId( student.getId() );
        studentDTO.setName( student.getName() );
        studentDTO.setPassword( student.getPassword() );
        studentDTO.setEmail( student.getEmail() );
        studentDTO.setSurname( student.getSurname() );
        studentDTO.setGroup( student.getGroup() );
        Set<Grade> set = student.getGradeSet();
        if ( set != null ) {
            studentDTO.setGradeSet( new HashSet<Grade>( set ) );
        }

        return studentDTO;
    }

    @Override
    public Student studentDTOtoStudent(StudentDTO studentDTO) {
        if ( studentDTO == null ) {
            return null;
        }

        Student student = new Student();

        student.setId( studentDTO.getId() );
        student.setName( studentDTO.getName() );
        student.setPassword( studentDTO.getPassword() );
        student.setEmail( studentDTO.getEmail() );
        student.setSurname( studentDTO.getSurname() );
        student.setGroup( studentDTO.getGroup() );
        Set<Grade> set = studentDTO.getGradeSet();
        if ( set != null ) {
            student.setGradeSet( new HashSet<Grade>( set ) );
        }

        return student;
    }

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
