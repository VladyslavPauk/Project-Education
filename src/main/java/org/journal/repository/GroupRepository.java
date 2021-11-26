package org.journal.repository;

import org.journal.model.Group;

import java.util.List;

public interface GroupRepository {
    Group getGroup(int id);

    List<Group> getGroups();

}
