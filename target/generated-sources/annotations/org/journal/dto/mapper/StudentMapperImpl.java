package org.journal.dto.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import org.journal.dto.GradeDTO;
import org.journal.dto.StudentDTO;
import org.journal.model.Grade;
import org.journal.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-08T21:05:21+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16.0.2 (Oracle Corporation)"
)
@Component
public class StudentMapperImpl implements StudentMapper {

    @Autowired
    private GroupMapper groupMapper;
    @Autowired
    private GradeMapper gradeMapper;

    @Override
    public StudentDTO toStudentDTOWithoutEntity(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentDTO studentDTO = new StudentDTO();

        studentDTO.setId( student.getId() );
        studentDTO.setName( student.getName() );
        studentDTO.setPassword( student.getPassword() );
        studentDTO.setEmail( student.getEmail() );
        studentDTO.setSurname( student.getSurname() );

        studentDTO.setGroup( null );

        return studentDTO;
    }

    @Override
    public StudentDTO toStudentDTO(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentDTO studentDTO = new StudentDTO();

        studentDTO.setGroup( groupMapper.toGroupDTOWithoutEntity( student.getGroup() ) );
        studentDTO.setId( student.getId() );
        studentDTO.setName( student.getName() );
        studentDTO.setPassword( student.getPassword() );
        studentDTO.setEmail( student.getEmail() );
        studentDTO.setSurname( student.getSurname() );

        return studentDTO;
    }

    @Override
    public Map<StudentDTO, List<GradeDTO>> ToGradesPerLessonInGroupDTO(Map<Student, List<Grade>> map) {
        if ( map == null ) {
            return null;
        }

        Map<StudentDTO, List<GradeDTO>> map1 = new HashMap<StudentDTO, List<GradeDTO>>( Math.max( (int) ( map.size() / .75f ) + 1, 16 ) );

        for ( java.util.Map.Entry<Student, List<Grade>> entry : map.entrySet() ) {
            StudentDTO key = toStudentDTOWithoutEntity( entry.getKey() );
            List<GradeDTO> value = gradeMapper.toGradeDToList( entry.getValue() );
            map1.put( key, value );
        }

        return map1;
    }

    @Override
    public Map<String, List<GradeDTO>> getGradesPerLessonDTo(Map<String, List<Grade>> map) {
        if ( map == null ) {
            return null;
        }

        Map<String, List<GradeDTO>> map1 = new HashMap<String, List<GradeDTO>>( Math.max( (int) ( map.size() / .75f ) + 1, 16 ) );

        for ( java.util.Map.Entry<String, List<Grade>> entry : map.entrySet() ) {
            String key = entry.getKey();
            List<GradeDTO> value = gradeMapper.toGradeDToList( entry.getValue() );
            map1.put( key, value );
        }

        return map1;
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

        return student;
    }
}
