package com.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class MapDemo {

	public static void main(String[] args) {
		 Configuration cfg = new Configuration();
	     cfg.configure("hibernate.cfg.xml");   
	     SessionFactory factory =cfg.buildSessionFactory();
       
	     Question q1=new Question();
	     q1.setQuestionId(1212);
	     q1.setQuestion("what is java?");
	     
	     
	     Answer aws =new Answer();
	     aws.setAnswerId(5678);
	     aws.setAnswer("Java is a programming language");
	     q1.setAnswer(aws);
	     
	     
	     Question q2=new Question();
	     q2.setQuestionId(1414);
	     q2.setQuestion("what is  collection framework?");
	     
	     
	     Answer aws1 =new Answer();
	     aws1.setAnswerId(8765);
	     aws1.setAnswer("API to work with objects in java");
	     q2.setAnswer(aws1);
	     
	     
	   
	     Session s= factory.openSession();
	     
	     Transaction tx =s.beginTransaction();
	    
	     s.save(q1);
	     s.save(q2);
	     s.save(aws1);
	     s.save(aws);
	    
	     
	     
	     
	     tx.commit();  
	     
	     s.close(); 
	     
	     factory.close();
	}

}
