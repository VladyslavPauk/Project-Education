package work.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import work.model.University;
import work.repository.UniversityRepositoryImp;

import java.util.List;

@Service
public class UniversityServiceImp implements UniversityService{
    @Autowired
    UniversityRepositoryImp universityRepositoryImp;

    @Override
    public List<University> getAllUniversity() {
        return universityRepositoryImp.getAllUniversity();
    }

    @Override
    public University getUniversity(int id) {
        return universityRepositoryImp.getUniversity(id);
    }

    @Override
    public void deleteUniversity(int id) {
        universityRepositoryImp.deleteUniversity(id);
    }

    @Override
    public void updateSUniversity(University university) {
        universityRepositoryImp.updateSUniversity(university);
    }

    @Override
    public void setUniversity(University university) {
        universityRepositoryImp.setUniversity(university);
    }
}
