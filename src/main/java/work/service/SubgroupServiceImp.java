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
    public Subgroup getSubgroup(int id) {
        return groupRepositoryImp.getSubgroup(id);
    }

    @Override
    public List<Subgroup> getSubgroups() {
        return groupRepositoryImp.getSubgroups();
    }

}
