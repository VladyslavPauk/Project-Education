package work.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import work.model.Subgroup;
import work.repository.SubgroupRepositoryImp;

import java.util.List;

@Service
public class SubgroupServiceImp implements SubgroupService {

    @Autowired
    private SubgroupRepositoryImp groupRepositoryImp;

    @Override
    public Subgroup getSubgroupById(int id) {
        return groupRepositoryImp.getSubgroupById(id);
    }

    @Override
    public List<Subgroup> getAllSubgroup() {
        return groupRepositoryImp.getAllSubgroup();
    }

    @Override
    public List<Subgroup> getAllSubgroupByTeacherId(int teacherId) {
        return groupRepositoryImp.getAllSubgroupByTeacherId(teacherId);
    }
}
