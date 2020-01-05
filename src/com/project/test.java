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
         emp.setLastName("temp");
         sec2.saveOrUpdate(emp);
        sec2.getTransaction().commit();


        HibernateUtil.down();
    }
}
