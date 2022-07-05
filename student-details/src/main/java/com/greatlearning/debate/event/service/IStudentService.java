package com.greatlearning.debate.event.service;

import java.util.List;

import com.greatlearning.debate.event.entity.Student;

public interface IStudentService {
	public Student addStudent(Student student);
	public boolean modifyStudent(int studentId);
	public Student findStudent (int studentId);
	public boolean removeStudent(int studentId);
	public List<Student> displayStudents();
}
