package org.journal.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.journal.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GroupRepositoryImp implements GroupRepository {

    @Autowired
    public SessionFactory sessionFactory;

    @Override
    public Group getGroup(int id) {
        Session session = sessionFactory.openSession();
       session.beginTransaction();
        Group group = session.get(Group.class, id);
        session.getTransaction().commit();
        session.close();
        return group;
    }

    @Override
    public List<Group> getAllGroups() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Group");
        List<Group> groupList = query.list();
       session.getTransaction().commit();
        session.close();
        return groupList;
    }

}
