package org.journal.service;

import org.journal.model.Subgroup;

import java.util.List;

public interface SubgroupService {
     Subgroup getSubgroup(int id);

     List<Subgroup> getSubgroups();

}
