package com.greatlearning.debate.event.dao;

import java.util.List;

import com.greatlearning.debate.event.entity.Student;

public interface IStudentDao {
	
	public Student insertStudentRecord(Student student);
	public Student updateStudentRecord(Student student);
	public boolean deleteStudentRecord(int studentId);
	public List<Student> printStudentRecord();




}
