package work.service;

import work.model.Subgroup;

import java.util.List;

public interface SubgroupService {
    public Subgroup getSubgroupById(int id);
    public List<Subgroup> getAllSubgroup();
}
