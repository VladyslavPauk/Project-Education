package work.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import work.configure.HibernateUtil;
import work.model.Student;
import java.util.List;

@Repository
public class StudentRepositoryImp implements StudentRepository {

    @Override
    public List<Student> getAllStudents() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Student");
        List<Student> studentList = query.list();
        session.close();
        return studentList;
    }

    @Override
    public Student getStudent(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Student student = session.get(Student.class, id);
        session.close();
        return student;
    }

    @Override
    public void deleteStudent(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.delete(getStudent(id));
        session.close();
    }

    @Override
    public void updateStudent(Student student) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.update(student);
        session.close();
    }

    @Override
    public void setStudent(Student student) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.save(student);
        session.close();
    }
}
