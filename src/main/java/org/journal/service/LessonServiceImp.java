package org.journal.service;

import org.journal.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.journal.model.Lesson;


@Service
public class LessonServiceImp implements  LessonService{
    @Autowired
    private LessonRepository lessonRepository;

    @Override
    public Lesson getLesson(int id) {
        return lessonRepository.getLesson(id);
    }
}
