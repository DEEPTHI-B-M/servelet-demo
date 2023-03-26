package com.hibernatehelloworld;

import org.hibernate.Session;

import com.hibernatehelloworld.domail.Address;
import com.hibernatehelloworld.domail.Person;
import com.hibernatehelloworld.utils.HibernateUtil;

public class Hibernatedemo {
	public static void main(String[]args) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Address address1=new Address("1234 Home street","Mysore","570012");
		Address address2=new Address("1234 Work street","Banglore","670012");
		Person person=new Person("Dee",address1,address2);
		session.save(person);
		session.getTransaction().commit();
		session.close();
	}
}
