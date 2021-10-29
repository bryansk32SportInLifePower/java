package ru.hibernate;

import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        Session session= HiberUtil.getSessionFack().openSession();
        session.close();
        HiberUtil.shutdown();
    }
}
