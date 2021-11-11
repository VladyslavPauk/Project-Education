package work.repository;

import work.model.Subgroup;

import java.util.List;

public interface SubgroupRepository {
    Subgroup getSubgroup(int id);

    List<Subgroup> getSubgroups();

}
