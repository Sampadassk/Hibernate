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
	     
	     
	     Answer answer =new Answer();
	     answer.setAnswerId(5678);
	     answer.setAnswer("Java is a programming language");
	     answer.setQuestion(q1);
	     q1.setAnswer(answer);
	     
	     
	     Question q2=new Question();
	     q2.setQuestionId(1414);
	     q2.setQuestion("what is  collection framework?");
	     
	     
	     Answer answer1 =new Answer();
	     answer1.setAnswerId(8765);
	     answer1.setAnswer("API to work with objects in java");
	     answer1.setQuestion(q2);
	     q2.setAnswer(answer1);
	     
	     
	   
	     Session s= factory.openSession();
	     
	     Transaction tx =s.beginTransaction();
	    
	     s.save(q1);
	     s.save(q2);
	     s.save(answer1);
	     s.save(answer);
	    
	     
	     
	     
	     tx.commit();  
	     
	     Question newQ = (Question) s.get(Question.class,1212);
	     System.out.println(newQ.getQuestion());
	     System.out.println(newQ.getAnswer().getAnswer());
	     
	     s.close(); 
	     
	     factory.close();
	}

}
