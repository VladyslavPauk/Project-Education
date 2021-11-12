package org.journal.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.journal.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TeacherRepositoryImp implements TeacherRepository {
    @Autowired
    public SessionFactory sessionFactory;

    @Override
    public Teacher getTeacher(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Teacher teacher = session.get(Teacher.class, id);
        session.getTransaction().commit();
        session.close();
        return teacher;
    }

    @Override
    public void saveTeacher(Teacher teacher) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(teacher);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteTeacher(Teacher teacher) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(teacher);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(teacher);
        session.getTransaction().commit();
        session.close();
    }

}
