package com.greatlearning.debate.event.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.debate.event.dao.IStudentDao;
import com.greatlearning.debate.event.entity.Student;

import javax.transaction.Transactional;

@Service
@Transactional
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private IStudentDao studentDao;
	
	@Override
	public Student addStudent(Student student) {
		return studentDao.insertStudentRecord(student);
	}

	@Override
	public boolean modifyStudent(int studentId) {
		return studentDao.updateStudentRecord(studentId);

	}

	@Override
	public Student findStudent(int studentId) {
		return studentDao.findStudentRecordStudent(studentId);
	}

	@Override
	public boolean removeStudent(int studentId) {
		return studentDao.deleteStudentRecord(studentId);
	}

	@Override
	public List<Student> displayStudents() {
		return studentDao.printStudentRecord();
	}

}
