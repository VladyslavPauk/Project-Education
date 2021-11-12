package org.journal.repository;

import org.journal.model.Lesson;

public interface LessonRepository {
    Lesson getLesson(int id);
}
