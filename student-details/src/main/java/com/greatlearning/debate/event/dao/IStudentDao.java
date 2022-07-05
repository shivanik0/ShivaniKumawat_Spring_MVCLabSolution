package com.greatlearning.debate.event.dao;

import java.util.List;


import com.greatlearning.debate.event.entity.Student;

public interface IStudentDao {
	
	public Student insertStudentRecord(Student student);
	public boolean updateStudentRecord(int studentId);
	public boolean deleteStudentRecord(int studentId);
	public Student findStudentRecordStudent(int studentId);
	public List<Student> printStudentRecord();




}
