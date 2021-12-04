package org.journal.service;

import org.journal.model.Group;
import org.journal.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GroupServiceImp implements GroupService {

    @Autowired
    private GroupRepository groupRepository;

    @Override
    public Group getGroup(int id) {
        return groupRepository.getGroup(id);
    }

    @Override
    public List<Group> getAllGroups() {
        return groupRepository.getAllGroups();
    }

}
