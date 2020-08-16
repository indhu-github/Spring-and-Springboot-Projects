package com.demo.HibMapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Laptop laptop=new Laptop();
        laptop.setLid(101);
        laptop.setLname("Hp");
        
        Student student=new Student();
        student.setRollno(1);
        student.setName("Don");
        student.setMarks(95);
        //student.getLaptop().add(laptop);
        //laptop.setStud(student);
        
        laptop.getStud().add(student);
        
        Configuration con=new Configuration().configure().addAnnotatedClass(Laptop.class).addAnnotatedClass(Student.class);
        ServiceRegistry reg=new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf=con.buildSessionFactory(reg);
        Session session=sf.openSession();
        
        session.beginTransaction();
        
        session.save(laptop);
        session.save(student);
        
        session.getTransaction().commit();
        
    }
}
