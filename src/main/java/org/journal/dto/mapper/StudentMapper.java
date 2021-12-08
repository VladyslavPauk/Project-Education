package org.journal.dto.mapper;


import org.journal.dto.GradeDTO;
import org.journal.dto.StudentDTO;
import org.journal.model.Grade;
import org.journal.model.Student;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Map;


@Named("StudentMapper")
@Mapper(componentModel = "spring", uses = {GroupMapper.class, GradeMapper.class})
public interface StudentMapper {
    StudentMapper STUDENT_MAPPER = Mappers.getMapper(StudentMapper.class);


    @Named("toStudentDTOWithoutEntity")
    @Mappings({
            @Mapping(target = "gradeSet", ignore = true),
            @Mapping(target = "group", expression = "java(null)")
    })
    StudentDTO toStudentDTOWithoutEntity(Student student);



    @Named("toStudentDTO")
    @Mappings({
            @Mapping(target = "gradeSet", ignore = true),
            @Mapping(target = "group", qualifiedByName = "toGroupDTOWithoutEntity")
    })
    StudentDTO toStudentDTO(Student student);



    @MapMapping(keyQualifiedByName = "toStudentDTOWithoutEntity")
    Map<StudentDTO, List<GradeDTO>> ToGradesPerLessonInGroupDTO(Map<Student, List<Grade>> map);

    Map<String, List<GradeDTO>> getGradesPerLessonDTo(Map<String, List<Grade>> map);


    @Mappings({
            @Mapping(target = "group", ignore = true),
            @Mapping(target = "gradeSet", ignore = true)
    })
    Student studentDTOtoStudent(StudentDTO studentDTO);

}
