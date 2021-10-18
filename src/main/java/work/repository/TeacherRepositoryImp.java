package work.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import work.model.Teacher;

import java.util.List;

@Repository
public class TeacherRepositoryImp implements TeacherRepository {
    @Autowired
    public SessionFactory sessionFactory;

    @Override
    public Teacher getTeacherById(int id) {
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
