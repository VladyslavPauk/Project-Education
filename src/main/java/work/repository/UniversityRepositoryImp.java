package work.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import work.model.University;

import java.util.List;

@Repository
public class UniversityRepositoryImp implements UniversityRepository{
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<University> getAllUniversity() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from University");
        List<University> list = query.list();
        session.getTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public University getUniversity(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        University university = session.get(University.class, id);
        session.getTransaction().commit();
        session.close();
        return university;
    }

    @Override
    public void deleteUniversity(int id) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    session.delete(getUniversity(id));
    session.getTransaction().commit();
    session.close();
    }

    @Override
    public void updateSUniversity(University university) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(university);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void setUniversity(University university) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(university);
        session.getTransaction().commit();
        session.close();
    }
}
