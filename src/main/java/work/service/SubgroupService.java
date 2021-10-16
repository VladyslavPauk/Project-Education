package work.service;

import work.model.Subgroup;
import work.model.Teacher;

import java.util.List;

public interface SubgroupService {
    public Subgroup getSubgroupById(int id);
    public List<Subgroup> getAllSubgroup();
    public List<Subgroup> getAllSubgroupByTeacherId(int teacherId);
}
