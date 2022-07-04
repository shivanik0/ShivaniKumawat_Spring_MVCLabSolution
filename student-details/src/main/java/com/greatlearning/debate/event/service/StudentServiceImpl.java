package com.greatlearning.debate.event.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.debate.event.dao.IStudentDao;
import com.greatlearning.debate.event.entity.Student;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private IStudentDao studentDao;
	
	@Override
	public Student addStudent(Student student) {
		return studentDao.insertStudentRecord(student);
	}

	@Override
	public Student modifyStudent(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student findStudent(int studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeStudent(int studentId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Student> displayStudents() {
		// TODO Auto-generated method stub
		return null;
	}

}
