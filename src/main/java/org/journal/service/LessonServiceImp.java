package org.journal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.journal.model.Lesson;
import org.journal.repository.LessonRepositoryImp;

@Service
public class LessonServiceImp implements  LessonService{
    @Autowired
    private LessonRepositoryImp lessonRepositoryImp;

    @Override
    public Lesson getLesson(int id) {
        return lessonRepositoryImp.getLesson(id);
    }
}
