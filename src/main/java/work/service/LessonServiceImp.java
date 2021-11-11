package work.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import work.model.Lesson;
import work.repository.LessonRepositoryImp;

@Service
public class LessonServiceImp implements  LessonService{
    @Autowired
    private LessonRepositoryImp lessonRepositoryImp;

    @Override
    public Lesson getLesson(int id) {
        return lessonRepositoryImp.getLesson(id);
    }
}
