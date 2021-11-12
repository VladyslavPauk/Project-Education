package org.journal.repository;

import org.journal.model.Subgroup;

import java.util.List;

public interface SubgroupRepository {
    Subgroup getSubgroup(int id);

    List<Subgroup> getSubgroups();

}
