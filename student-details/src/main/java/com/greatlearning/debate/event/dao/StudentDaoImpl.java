package com.greatlearning.debate.event.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.greatlearning.debate.event.entity.Student;

@Repository
public class StudentDaoImpl implements IStudentDao {

	private SessionFactory sessionFactory;
	private Session session;
	
	public StudentDaoImpl(SessionFactory sessionFactory) {
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
		Transaction txnTransaction=session.beginTransaction();
		session.save(student);
		System.out.println("Student Info Saved");
		txnTransaction.commit();
		return student;
	}

	@Override
	public boolean updateStudentRecord(int studentId) {
		Student retrievedObject=findStudentRecordStudent(studentId);
		session.getTransaction().begin();
		retrievedObject.setName("Nancy");
		//session.createQuery("Update Student s set s.name='Nancy' where s.id=studentId");
		session.update(retrievedObject);
		session.getTransaction().commit();
		
		if(retrievedObject!=null) {
			return true;
		}
		return false;
	}
	
	@Override
	public Student findStudentRecordStudent(int studentId) {
		
		return session.find(Student.class, new Integer(studentId));
	}


	@Override
	public boolean deleteStudentRecord(int studentId) {
	Student retrievedObject=findStudentRecordStudent(studentId);
		
		session.getTransaction().begin();
		System.out.println("deleting student country is: "+retrievedObject.getCountry());
		session.delete(retrievedObject);
		
		session.getTransaction().commit();
		
		if(retrievedObject!=null) {
			return true;
		}
		return false;
	}

	@Override
	public List<Student> printStudentRecord() {
		return session.createQuery("Select s from Student s", Student.class).getResultList();
	}

}
