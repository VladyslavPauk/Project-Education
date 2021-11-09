package work.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import work.model.Grade;

@Repository
public class GradeRepositoryImp implements GradeRepository {

    @Autowired
    SessionFactory sessionFactory;

    public void addGrade(Grade grade) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(grade);
        session.getTransaction().commit();
        session.close();
    }
}
