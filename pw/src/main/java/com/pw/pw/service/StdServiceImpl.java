package com.pw.pw.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pw.pw.dao.StdDaoImpl;
import com.pw.pw.entity.Student;

import jakarta.transaction.Transactional;

@Service
public class StdServiceImpl implements StdService{

	@Autowired
	StdDaoImpl daoImpl;
	@Override
	public Student saveStudent(Student student) {
		return daoImpl.saveStudent(student);
	}

	@Override
	public Student getStudentById(int stdId) {
		return daoImpl.getStudentById(stdId);
	}

	@Override
	public List<Student> getAllStudent() {
		return daoImpl.getAllStudent();
	}

	

	@Override
	public void deletStundetById(int stdId) {
		List<Integer> stdList = getListOfAllIds();
		@SuppressWarnings("unused")
		Student stdDel=null;
		for (Integer id : stdList) {
			System.out.println(id==stdId);
	        if (id==stdId) {
	        	stdDel=daoImpl.getStudentById(stdId);
	            break;  
	        }
	    }
		if (stdDel==null) {
	        return;
	    }
		daoImpl.deletStundetById(stdId);	
	}

	@Override
	public void deleteAllStudent() {
		daoImpl.deleteAllStudent();
	}

	@SuppressWarnings({ })
	@Override
	@Transactional
	public Student updateStudentById(int stdId, Student newStudent) {
		
		List<Integer> stdList = getListOfAllIds();
		Student existingStudent = null;
		
		for (Integer id : stdList) {
			System.out.println(id==stdId);
	        if (id==stdId) {
	        	existingStudent = new Student();
	        	existingStudent.setStdId(stdId);
	        	existingStudent.setFirstName(newStudent.getFirstName());
	    	    existingStudent.setLastName(newStudent.getLastName());
	    	    existingStudent.setContct(newStudent.getContct());
	    	    existingStudent.setEmail(newStudent.getEmail());
	    	    existingStudent.setAddress(newStudent.getAddress());
	    	    
	            break;  
	        }
	    }
		
		if (existingStudent==null) {
	        return null;
	    }

	
//	    Student upadatedStd = daoImpl.updateStudentById(stdId, existingStudent);
		
		return daoImpl.updateStudentById(stdId, existingStudent);
	}

	@Override
	public  List<Integer> getListOfAllIds() {
		List<Student> stdList = daoImpl.getAllStudent();
		
		List<Integer>stdL=stdList.stream().map(Student:: getStdId).collect(Collectors.toList());
		
		return stdL;
	}


}
