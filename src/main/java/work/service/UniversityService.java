package work.service;

import work.model.University;
import work.repository.UniversityRepositoryImp;

import java.util.List;

public interface UniversityService {

    public List<University> getAllUniversity();
    public University getUniversity(int id);
    public void deleteUniversity(int id);
    public void updateSUniversity(University university);
    public void setUniversity(University university);
}
