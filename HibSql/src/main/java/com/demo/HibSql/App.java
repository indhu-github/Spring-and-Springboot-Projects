package com.demo.HibSql;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
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
    	
    	Configuration con=new Configuration().configure().addAnnotatedClass(Student.class);
        ServiceRegistry reg=new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf=con.buildSessionFactory(reg);
        Session session=sf.openSession();
        int b=60;
        
        session.beginTransaction();
        
        /*Random r=new Random();
        for(int i=1;i<=50;i++) 
        {
        	Student s=new Student();
        	s.setId(i);
        	s.setName("Name"+i);
        	s.setMarks(r.nextInt(100));
        	session.save(s);
        	
        }*/
        
        /*Query q=session.createQuery("FROM Student where marks>50");
		List<Student> students=q.list();
        
        for(Student s : students)
        {
        	System.out.println(s);
        }*/
       
        
        /*Query q=session.createQuery("FROM Student where id=7");
		Student student=(Student) q.uniqueResult();
        
        System.out.println(student);
        */
        
        /*Query q=session.createQuery("select id,name,marks from Student where id=7");
        Object[] student=(Object[]) q.uniqueResult();
        
        System.out.println(student[0]+" : "+student[1]+" : "+student[2]);
        */
        
        /*Query q=session.createQuery("select id,name,marks from Student s where s.marks>60");
        List<Object[]> students=(List<Object[]>) q.list();
        
        for(Object[] student:students)
        	System.out.println(student[0]+" : "+student[1]+" : "+student[2]);
        */
        
        
        /*Query q=session.createQuery("select sum(marks) from Student where marks>60");
        Long marks=(Long) q.uniqueResult();
        
        System.out.println(marks);
        */
        
        
        /*Query q=session.createQuery("select sum(marks) from Student where marks>:b");
        q.setParameter("b",b);
        Long marks=(Long) q.uniqueResult();
        
        System.out.println(marks);
        */
       
        /*
        //Native Query i.e., SQL in Hibernate
        SQLQuery q=session.createSQLQuery("select * from Student where marks>60");
        q.addEntity(Student.class);
        List<Student> students=q.list();
        
        for(Student o:students)
        {
        	System.out.println(o);
        }
        */
        
        //Native Query
        SQLQuery q=session.createSQLQuery("select name,marks from Student where marks>60");
        q.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List students=q.list();
        
        for(Object o:students)
        {
        	Map m=(Map)o;
        	System.out.println(m.get("name")+" : "+m.get("marks"));
        }
        session.getTransaction().commit();
        
        
    }
}
