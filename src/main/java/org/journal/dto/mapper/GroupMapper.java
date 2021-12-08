package org.journal.dto.mapper;

import org.journal.dto.GroupDTO;
import org.journal.model.Group;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(componentModel = "spring", uses = {StudentMapper.class, TeacherMapper.class, LessonMapper.class})
public interface GroupMapper {
    GroupMapper GROUP_MAPPER = Mappers.getMapper(GroupMapper.class);


    @Mappings({
            @Mapping(target = "lessonSet", ignore = true),
            @Mapping(target = "studentSet", qualifiedByName = "toStudentDTOWithoutEntity")
    })
    GroupDTO toGroupDTO(Group group);




    @Named("toGroupDTOWithoutEntity")
    @Mappings({
            @Mapping(target = "lessonSet", ignore = true),
            @Mapping(target = "studentSet", ignore = true),
            @Mapping(target = "teacher", ignore = true)
    })
    GroupDTO toGroupDTOWithoutEntity(Group group);




    @IterableMapping(qualifiedByName = "toGroupDTOWithoutEntity")
    List<GroupDTO> toGroupDtoList(List<Group> groups);

}
