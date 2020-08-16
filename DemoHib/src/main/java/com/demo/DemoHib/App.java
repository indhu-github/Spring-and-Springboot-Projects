package com.demo.DemoHib;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
    	AlienName an=new AlienName();
    	an.setFname("Indhu");
    	an.setLname("Kumari");
    	an.setMname("Devi");
    	
         Alien a=new Alien();
    	//Alien a=null; //no need to create obj coz we are creating at below
        
        a.setAid(107);
        a.setAname(an);
        a.setColor("Green");
        
        Configuration con=new Configuration().configure().addAnnotatedClass(Alien.class);
        ServiceRegistry reg=new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf=con.buildSessionFactory(reg);
        Session session=sf.openSession();
        
        Transaction tx=session.beginTransaction();
        
        session.save(a);
        
        //a=(Alien) session.get(Alien.class, 105); //this is for fetching the data
        
        tx.commit();
        
        System.out.println(a);
        session.close();
    }
}
