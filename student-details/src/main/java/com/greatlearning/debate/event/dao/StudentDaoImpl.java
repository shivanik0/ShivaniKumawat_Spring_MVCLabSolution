package com.greatlearning.debate.event.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.greatlearning.debate.event.entity.Student;

@Repository
public class StudentDaoImpl implements IStudentDao {

	private SessionFactory sessionFactory;
	private Session session;
	
	public void StudentDaoImpl(SessionFactory sessionFactory) {
		System.out.println("Connecting to database");

		this.sessionFactory = sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
	}

	@Override
	public Student insertStudentRecord(Student student) {
		//Transaction txnTransaction=session.beginTransaction();
		session.persist(student);
		System.out.println("Student Info Saved");
		//txnTransaction.commit();
		return student;
	}

	@Override
	public Student updateStudentRecord(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteStudentRecord(int studentId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Student> printStudentRecord() {
		// TODO Auto-generated method stub
		return null;
	}

}
