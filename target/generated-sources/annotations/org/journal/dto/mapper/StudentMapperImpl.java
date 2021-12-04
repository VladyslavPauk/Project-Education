package org.journal.dto.mapper;

import java.util.HashSet;
import java.util.Set;
import javax.annotation.Generated;
import org.journal.dto.StudentDTO;
import org.journal.model.Grade;
import org.journal.model.Student;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-04T20:28:13+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.2 (Oracle Corporation)"
)
public class StudentMapperImpl implements StudentMapper {

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
}
