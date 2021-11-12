package org.journal.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.journal.model.Subgroup;

import java.util.List;

@Repository
public class SubgroupRepositoryImp implements SubgroupRepository {

    @Autowired
    public SessionFactory sessionFactory;

    @Override
    public Subgroup getSubgroup(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Subgroup subgroup = session.get(Subgroup.class, id);
        session.getTransaction().commit();
        session.close();
        return subgroup;
    }

    @Override
    public List<Subgroup> getSubgroups() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Subgroup");
        List<Subgroup> subgroupList = query.list();
        session.getTransaction().commit();
        session.close();
        return subgroupList;
    }

}
