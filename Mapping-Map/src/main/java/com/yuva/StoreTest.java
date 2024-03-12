package com.yuva;

import java.util.HashMap;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration; 

public class StoreTest {
    public static void main(String[] args) {
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        HashMap<String, String> map1 = new HashMap<String, String>();
        map1.put("Java is a programming language", "John Milton");
        map1.put("Java is a platform", "Ashok Kumar");

        HashMap<String, String> map2 = new HashMap<String, String>();
        map2.put("Servlet technology is a server side programming", "John Milton");
        map2.put("Servlet is an Interface", "Ashok Kumar");
        map2.put("Servlet is a package", "Rahul Kumar");

        Question question1 = new Question("What is Java?", "Alok", map1);
        Question question2 = new Question("What is Servlet?", "Jai Dixit", map2);

        session.persist(question1);
        session.persist(question2);

        t.commit();
        session.close();
        System.out.println("successfully stored");
    }
}
