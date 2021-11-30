package org.journal.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.journal.model.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GradeRepositoryImp implements GradeRepository {

    @Autowired
    public SessionFactory sessionFactory;

    public void addGrade(Grade grade) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(grade);
        session.getTransaction().commit();
        session.close();
    }
}
