package com.hibernatehelloworld;

import org.hibernate.Session;

import com.hibernatehelloworld.domail.Message;
import com.hibernatehelloworld.utils.HibernateUtil;

public class Hibernatedemo {
	public static void main(String[]args) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Message message=new Message("Hello world");
		session.save(message);
		session.getTransaction().commit();
		session.close();
	}
}
