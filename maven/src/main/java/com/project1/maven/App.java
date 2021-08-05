package com.project1.maven;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       Alien zoho = new Alien();
       zoho.setId(101);
       zoho.setName("sam");
       zoho.setColor("red");
       
      Configuration con = new Configuration();
      
     
       SessionFactory sf =con.buildSessionFactory();
       
       Session session =sf.openSession();
       session.save(zoho);
    }
}
