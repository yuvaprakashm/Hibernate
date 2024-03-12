package net.javaguides.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import net.javaguides.hibernate.entity.Student;
import net.javaguides.hibernate.util.HibernateUtil;

public class App {
    public static void main(String[] args) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Student student = new Student("Ramesh", "Fadatare", "rameshfadatare@javaguides.com");
            Student student1 = new Student("John", "Cena", "john@javaguides.com");
            // start a transaction
            transaction = session.beginTransaction();
            // save the student objects
            session.persist(student);
            session.persist(student1);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Student> students = session.createQuery("from Student", Student.class).list();
            students.forEach(s -> System.out.println(s.getEmail()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
