package com.tut.ProjectWithMaven;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {
	public static void main( String[] args ) {
		  
		
		 Configuration cfg = new Configuration();
	        cfg.configure("hibernate.cfg.xml");   
	        SessionFactory factory =cfg.buildSessionFactory();
	         Student student1=new Student();
	         student1.setId(1234);
	         student1.setName("Sampada");
	         student1.setCity("GLB");


	         Certificate certificate=new Certificate();
	         certificate.setCourse("Android");
	         certificate.setDuration("2 months");
	         student1.setCerti(certificate);
	         
	         Student student2=new Student();
	         student2.setId(4321);
	         student2.setName("Kulkarni");
	         student2.setCity("KLB");


	         Certificate certificate1=new Certificate();
	         certificate.setCourse("OS");
	         certificate.setDuration("3 months");
	         student2.setCerti(certificate);
	         
	         Session s=factory.openSession();
	         Transaction tx=s.beginTransaction();
	         
	         s.save(student1);
	         s.save(student2);
	         
	         tx.commit();
	         s.close();
	        factory.close();
	}
}
