package com.project;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sf=buildSessionFactory();

    private static SessionFactory buildSessionFactory()
    {
        return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sf;
    }

    public static void down()
    {
        getSessionFactory().close();

    }



}
