package com.tut.ProjectWithMaven;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "project started.." );
        
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");   
        SessionFactory factory =cfg.buildSessionFactory();
        //creating students
        Student st=new Student();
        st.setId(101);
        st.setName("SAM");
        st.setCity("GULBARGA");
        System.out.println(st);
        Session session=factory.openSession();
        Transaction tx=session.beginTransaction();
        session.save(st);
        tx.commit();
        session.close();
        
        
        
    }
}
