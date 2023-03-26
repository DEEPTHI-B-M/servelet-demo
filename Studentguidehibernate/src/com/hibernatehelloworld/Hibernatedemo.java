package com.hibernatehelloworld;

import org.hibernate.Session;

import com.hibernatehelloworld.domail.Address;
import com.hibernatehelloworld.domail.Guide;
import com.hibernatehelloworld.domail.Person;
import com.hibernatehelloworld.domail.Student;
import com.hibernatehelloworld.utils.HibernateUtil;

public class Hibernatedemo {
	public static void main(String[]args) {
		//demo1();
		demo2();
		demo3();
	}
	
	private static void demo3() {
		Session session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Guide guide=session.get(Guide.class, 1L);
		System.out.println("Number of students for this guide=" +guide.getStudents().size());
		session.getTransaction().commit();
		session.close();
	}
	
	private static void demo2() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Guide guide=new Guide("ABSJ12334","mangala",2000);
		Student student1=new Student("STU001","ambuja",guide);
		session.persist(student1);
		session.getTransaction().commit();
		session.close();
	}
}
