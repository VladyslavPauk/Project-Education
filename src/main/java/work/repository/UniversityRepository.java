package work.repository;

import work.model.University;

import java.util.List;

public interface UniversityRepository {
    public List<University> getAllUniversity();
    public University getUniversity(int id);
    public void deleteUniversity(int id);
    public void updateSUniversity(University university);
    public void setUniversity(University university);
}
