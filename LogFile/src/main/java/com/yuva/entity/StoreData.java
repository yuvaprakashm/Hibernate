package com.yuva.entity;
import org.hibernate.*;
import org.hibernate.cfg.*;

public class StoreData {
public static void main(String[] args) {
	
	Configuration cfg=new Configuration();
	cfg.configure("hibernate.cfg.xml");
	
	SessionFactory factory=cfg.buildSessionFactory();
	Session session=factory.openSession();
	Transaction tx=session.beginTransaction();
	
	session.save(new Employee("Arun",380000));
	session.save(new Employee("Varun",480000));
	
	tx.commit();
	session.close();
	System.out.println("record successfully persisted");
	
}
}
