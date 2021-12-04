package org.journal.dto.mapper;

import org.journal.dto.GroupDTO;
import org.journal.model.Group;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GroupMapper {
    GroupMapper GROUP_MAPPER = Mappers.getMapper(GroupMapper.class);

    GroupDTO toGroupDTO(Group group);

    @InheritInverseConfiguration
    Group groupDTOtoGroup(GroupDTO groupDTO);
}
