package org.journal.dto.mapper;

import org.journal.dto.GroupDTO;
import org.journal.model.Group;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring", uses = {StudentMapper.class, TeacherMapper.class, LessonMapper.class})
public interface GroupMapper {
    GroupMapper GROUP_MAPPER = Mappers.getMapper(GroupMapper.class);

    @Mappings({
            @Mapping(target = "lessonSet", ignore = true),
            @Mapping(target = "studentSet", qualifiedByName = "toStudentDTOWithoutGroup")
    })
    GroupDTO toGroupDTO(Group group);

}
