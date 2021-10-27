package work.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import work.model.Lesson;

@Repository
public class LessonRepositoryImp implements LessonRepository {

    @Autowired
    public SessionFactory sessionFactory;
    @Override
    public Lesson getLessonById(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Lesson lesson = session.get(Lesson.class, id);
        session.getTransaction().commit();
        session.close();
        return lesson;
    }
}
