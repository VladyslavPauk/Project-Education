package org.journal.service;

import org.journal.model.Group;
import org.journal.repository.GroupRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GroupServiceImp implements GroupService {

    @Autowired
    private GroupRepositoryImp groupRepositoryImp;

    @Override
    public Group getGroup(int id) {
        return groupRepositoryImp.getGroup(id);
    }

    @Override
    public List<Group> getGroups() {
        return groupRepositoryImp.getGroups();
    }

}
