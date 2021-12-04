package org.journal.dto.mapper;

import org.journal.dto.StudentDTO;
import org.journal.model.Student;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper()
public interface StudentMapper {
    StudentMapper STUDENT_MAPPER = Mappers.getMapper(StudentMapper.class);

    StudentDTO toStudentDTO(Student student);
    @InheritInverseConfiguration
    Student studentDTOtoStudent(StudentDTO studentDTO);

}
