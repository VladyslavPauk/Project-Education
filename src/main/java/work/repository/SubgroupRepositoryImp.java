package work.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import work.model.Subgroup;

import java.util.List;

@Repository
public class SubgroupRepositoryImp implements SubgroupRepository {

    @Autowired
    public SessionFactory sessionFactory;

    @Override
    public Subgroup getSubgroupById(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Subgroup subgroup = session.get(Subgroup.class, id);
        session.getTransaction().commit();
        session.close();
        return subgroup;
    }

    @Override
    public List<Subgroup> getAllSubgroup() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Subgroup");
        List<Subgroup> subgroupList = query.list();
        session.getTransaction().commit();
        session.close();
        return subgroupList;
    }
}
