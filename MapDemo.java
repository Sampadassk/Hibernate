package com.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import java.util.ArrayList;



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
	    
	     Answer answer1 =new Answer();
	     answer1.setAnswerId(5676);
	     answer1.setAnswer("With the help of java we can create softwares");
	     answer1.setQuestion(q1);
	    
	     Answer answer2 =new Answer();
	     answer2.setAnswerId(5674);
	     answer2.setAnswer("Java has different types of frameworks");
	     answer2.setQuestion(q1);
	    
	     ArrayList<Answer> list=new ArrayList<Answer>();
	     
	     list.add(answer);
	     list.add(answer1);
	     list.add(answer2);
	     q1.setAnswers(list);
	     
	     
	     
	     Session s= factory.openSession();
	     
	     Transaction tx =s.beginTransaction();
	     s.save(q1);
	     s.save(answer);
	     s.save(answer1);
	     s.save(answer2);
	    
	     tx.commit();  
	     
	  
	     s.close(); 
	     
	     factory.close();
	}

}
