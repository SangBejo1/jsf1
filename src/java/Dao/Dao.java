package Dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.NewHibernateUtil;
import pojo.Student;

public class Dao {
    
    public void addStudent(Student student)
    {
        Transaction trans=null;
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        try 
        {
            trans=session.beginTransaction();
            session.save(student);
            trans.commit();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    public void deleteStudent(int id)
    {
        Transaction trans=null;
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        try 
        {
            trans=session.beginTransaction();
            Student stud=(Student)session.load(Student.class, new Integer(id));
            session.delete(stud);
            trans.commit();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    public List<Student> getbyID(int sno)
    {
        Student student=new Student();
        List<Student> student1=new ArrayList();
       
         Transaction trans=null;
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        try 
        {
            trans=session.beginTransaction();
            Query query=session.createQuery("from Student where id= :id");
            query.setInteger("id", sno);
            student=(Student)query.uniqueResult();
            student1=query.list();
            
            trans.commit();
        }
        catch(Exception e)
        {
            
        }
        return student1;
    }
    
    public List<Student> retrieveStudent()
    {
       
        List stud=new ArrayList();
        Student stud1=new Student();
        Transaction trans=null;
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        try
        {
            trans=session.beginTransaction();
            Query query=session.createQuery("from Student");
            stud=query.list();
            stud.add(stud1.getName());
            stud.add(stud1.getDepartment());
           
         
            trans.commit();
            
        }
        catch(Exception e)
        {
            
        }
        return stud;
    }
    
    public void updateStudent(Student student)
    {
        Transaction trans=null;
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        try 
        {
            trans=session.beginTransaction();
            session.update(student);
            trans.commit();
        }
        catch(Exception e)
        {
            
        }
        
    }
    
}