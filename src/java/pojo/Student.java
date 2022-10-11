package pojo;

import Dao.Dao;
import java.util.List;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class Student  implements java.io.Serializable {


     private int id;
     private String name;
     private String department;

    public Student() {
    }

	
    public Student(int id) {
        this.id = id;
    }
    public Student(int id, String name, String department) {
       this.id = id;
       this.name = name;
       this.department = department;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getDepartment() {
        return this.department;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }


public void save()
{
    Dao sdao=new Dao();
    sdao.addStudent(this);
}

public void delete()
{    
    Dao sdao=new Dao();
    sdao.deleteStudent(id);
}

public List<Student> getbyid()
{ 
    Dao sdao=new Dao();
    List<Student> stud=sdao.getbyID(id);
    name=stud.get(0).name;
    department=stud.get(0).department;
    return stud;
}

public List<Student> getallrecords()
{
    Dao sdao=new Dao();
    List<Student> stud=sdao.retrieveStudent();
    return stud;
}

public void update()
{
    Dao sdao=new Dao();
    sdao.updateStudent(this);
}

}