package com.project;

import org.hibernate.Session;

public class test {

    public static void main(String ar[])
    {
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        System.out.println("Starting process");
        Employee emp=new Employee();
        emp.setEmail("ash@gmail.com");
        emp.setFirstName("ashish1");
        emp.setLastName("chopra");

        session.save(emp);
        Integer id=emp.getEmpId();
        System.out.println("employee data saved");
        session.getTransaction().commit();

        Session sec2=HibernateUtil.getSessionFactory().openSession();
        sec2.beginTransaction();
        Employee e1=(Employee) sec2.load(Employee.class,id);
        System.out.println("1 "+e1.getFirstName());
        sec2.getTransaction().commit();

        Session sec3=HibernateUtil.getSessionFactory().openSession();
        sec3.beginTransaction();
        Employee e2=(Employee) sec3.load("com.project.Employee",id);
        System.out.println("2 "+e2.getFirstName());
        sec3.getTransaction().commit();

        Session sec4=HibernateUtil.getSessionFactory().openSession();
        sec4.beginTransaction();
        Employee e3=new Employee();
        sec4.load(e3,id);
        System.out.println("3 "+e3.getFirstName());
        sec4.getTransaction().commit();


        HibernateUtil.down();
    }
}
