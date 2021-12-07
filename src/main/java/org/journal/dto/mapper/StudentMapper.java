package org.journal.dto.mapper;


import org.journal.dto.StudentDTO;
import org.journal.model.Student;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;


@Named("StudentMapper")
@Mapper(componentModel = "spring", uses = {GroupMapper.class, GradeMapper.class})
public interface StudentMapper {
    StudentMapper STUDENT_MAPPER = Mappers.getMapper(StudentMapper.class);

    @Named("toStudentDTO")
    @Mappings({
            @Mapping(target = "gradeSet", ignore = true)
    })
    StudentDTO toStudentDTO(Student student);


    @Named("toStudentDTOWithoutGroup")
    @Mappings({
            @Mapping(target = "gradeSet", ignore = true),
            @Mapping(target = "group", expression = "java(null)")
    })
    StudentDTO toStudentDTOWithoutGroup(Student student);


    @InheritInverseConfiguration(name = "toStudentDTO")
    @Mappings({
            @Mapping(target = "gradeSet", ignore = true)
    })
    Student studentDTOtoStudent(StudentDTO studentDTO);

}
