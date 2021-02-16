package com.helman;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.Work;

import java.sql.Connection;
import java.sql.SQLException;

public class Mysession {
    private static final SessionFactory session;

    static {
        try{
            session = new Configuration().configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Product.class)
                    .buildSessionFactory();
        } catch (Throwable e){
            throw new ExceptionInInitializerError(e);
        }
    }

    public static Session getsession(){
        return session.openSession();
    }

    public static void closesession(){
        session.getCurrentSession().close();
    }


    public static Connection getconnection() {
        final Connection[] con = new Connection[1];
        getsession().doWork(new Work() {
            @Override
            public void execute(Connection connection) throws SQLException {
                con[0] =connection;
            }
        });
        return con[0];
    }
}