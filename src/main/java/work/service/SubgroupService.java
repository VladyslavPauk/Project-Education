package work.service;

import work.model.Subgroup;

import java.util.List;

public interface SubgroupService {
     Subgroup getSubgroup(int id);

     List<Subgroup> getSubgroups();

}
