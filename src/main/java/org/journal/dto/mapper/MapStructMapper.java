package org.journal.dto.mapper;

import org.journal.dto.*;
import org.journal.model.*;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MapStructMapper {
//    GradeMapper GRADE_MAPPER = Mappers.getMapper(GradeMapper.class);
//    GroupMapper GROUP_MAPPER = Mappers.getMapper(GroupMapper.class);
//    LessonMapper LESSON_MAPPER = Mappers.getMapper(LessonMapper.class);
//    StudentMapper STUDENT_MAPPER = Mappers.getMapper(StudentMapper.class);
//    TeacherMapper TEACHER_MAPPER = Mappers.getMapper(TeacherMapper.class);

    GradeDTO toGradeDTO(Grade grade);
    @InheritInverseConfiguration
    Grade gradeDTOtoGrade(GradeDTO gradeDTO);

    GroupDTO toGroupDTO(Group group);
    @InheritInverseConfiguration
    Group groupDTOtoGroup(GroupDTO groupDTO);

    LessonDTO toLessonDTO(Lesson lesson);
    @InheritInverseConfiguration
    Lesson lessonDTOtoLesson(LessonDTO lessonDTO);

    StudentDTO toStudentDTO(Student student);
    @InheritInverseConfiguration
    Student studentDTOtoStudent(StudentDTO studentDTO);

    TeacherDTO toTeacherDTO(Teacher teacher);
    @InheritInverseConfiguration
    Teacher teacherDTOtoTeacher(TeacherDTO teacherDTO);
}
