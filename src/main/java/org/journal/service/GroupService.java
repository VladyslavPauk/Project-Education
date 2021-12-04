package org.journal.service;

import org.journal.model.Group;

import java.util.List;

public interface GroupService {
     Group getGroup(int id);

     List<Group> getAllGroups();

}
