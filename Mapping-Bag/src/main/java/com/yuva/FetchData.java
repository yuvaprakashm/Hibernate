package com.yuva;    
    
import javax.persistence.TypedQuery;  
import java.util.*;  
import org.hibernate.*;  
import org.hibernate.boot.Metadata;  
import org.hibernate.boot.MetadataSources;  
import org.hibernate.boot.registry.StandardServiceRegistry;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;    
  
    
public class FetchData {    
public static void main(String[] args) {    
        
    StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
     Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();  
       
     SessionFactory factory=meta.buildSessionFactory();  
     Session session=factory.openSession();  
        
    TypedQuery query=session.createQuery("from Question");    
    List<Question> list=query.getResultList();    
        
    Iterator<Question> itr=list.iterator();    
    while(itr.hasNext()){    
        Question q=itr.next();    
        System.out.println("Question Name: "+q.getQname());    
            
        //printing answers    
        List<String> list2=q.getAnswers();    
        Iterator<String> itr2=list2.iterator();    
        while(itr2.hasNext()){    
            System.out.println(itr2.next());    
        }    
            
    }    
    session.close();    
    System.out.println("success");    
        
}    
}    