package org.journal.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.journal.model.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LessonRepositoryImp implements LessonRepository {

    @Autowired
    public SessionFactory sessionFactory;
    @Override
    public Lesson getLesson(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Lesson lesson = session.get(Lesson.class, id);
        session.getTransaction().commit();
        session.close();
        return lesson;
    }
}
