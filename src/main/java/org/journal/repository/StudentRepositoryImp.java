package org.journal.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.journal.model.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.journal.model.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Repository
public class StudentRepositoryImp implements StudentRepository {
    @Autowired
    public SessionFactory sessionFactory;

    @Override
    public List<Student> getStudents() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Student");
        List<Student> studentList = query.list();
        session.getTransaction().commit();
        session.close();
        return studentList;
    }

    @Override
    public Student getStudent(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Student student = session.get(Student.class, id);
        session.getTransaction().commit();
        session.close();
        return student;
    }

    public Student getStudent(String email) {
        Student student = null;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Student where email = :email");
        query.setParameter("email", email);
        List<Student> list = query.list();
        for (Student st : list) {
            student = st;
        }
        session.getTransaction().commit();
        session.close();
        return student;
    }

    public Map<Student, List<Grade>> getStudentGradesMap(int lessonId, Set<Student> students) {
        Map<Student, List<Grade>> studentGradesMap = new HashMap<>();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        for (Student student : students) {
            int studentId = student.getId();

            Query query = session.createQuery("from Grade as grade where grade.lesson.id =:lessonId and grade.student.id =: studentId");
            query.setParameter("lessonId", lessonId);
            query.setParameter("studentId", studentId);
            List<Grade> grades = query.list();
            studentGradesMap.put(student, grades);
        }
        session.getTransaction().commit();
        session.close();
        return studentGradesMap;
    }

    @Override
    public void deleteStudent(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(getStudent(id));
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updateStudent(Student student) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(student);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void saveStudent(Student student) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
        session.close();
    }

}
