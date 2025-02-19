package com.pw.pw.dao;

import java.util.List;

import com.pw.pw.entity.Student;

public interface StdDao {
	
	public Student saveStudent(Student Student);
	public Student getStudentById(int stdId);
	public List<Student> getAllStudent();
	public void deletStundetById(int stdId);
	public void deleteAllStudent();
	
	public Student updateStudentById(int stdId,Student Student);
	
	public List<Integer> getListOfAllIds();

}
