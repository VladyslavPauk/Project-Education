package work.repository;

import work.model.Subgroup;

import java.util.List;

public interface SubgroupRepository {
    public Subgroup getSubgroupById(int id);
    public List<Subgroup> getAllSubgroup();
}
