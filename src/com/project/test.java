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
        emp.setFirstName("ashish");
        emp.setLastName("chopra");

        session.save(emp);

        System.out.println("employee data saved");

        session.getTransaction().commit();
        HibernateUtil.down();
    }
}
