package com.pw.pw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pw.pw.entity.Student;
import com.pw.pw.service.StdServiceImpl;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/pwstd")
public class StdController {

	
	@Autowired
	StdServiceImpl serviceImpl;
	
	@PostMapping("/student")
	public ResponseEntity<Student> saveStudent(@RequestBody Student Student){
		
		Student saveStudent= serviceImpl.saveStudent(Student);
		return new ResponseEntity<>(saveStudent, HttpStatus.CREATED);
	}
	
	@GetMapping("/student/{std_id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("std_id") int stdId){

		Student saveStudent = serviceImpl.getStudentById(stdId);
		return new ResponseEntity<>(saveStudent, HttpStatus.OK);
	}
	
	@GetMapping("/students")
	public ResponseEntity<java.util.List<Student>> getAllStudents(){
		
		List<Student> saveStudent = serviceImpl.getAllStudent();
		return new ResponseEntity<>(saveStudent, HttpStatus.OK);
	}
	
	@PutMapping("/student/{std_id}")
	@Transactional
	public ResponseEntity<Student> updateStudentById(@PathVariable("std_id") int stdId, @RequestBody Student newStudent){

		Student updatedStd=serviceImpl.updateStudentById(stdId, newStudent);
	
		return new ResponseEntity<>(updatedStd, HttpStatus.OK);
	}
	
	@DeleteMapping("/student/{std_id}")
	public ResponseEntity deleteStudentById(@PathVariable("std_id") int stdI){
		
		serviceImpl.deletStundetById(stdI);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/students")
	public ResponseEntity deleteAllStudets(){
		
		serviceImpl.deleteAllStudent();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
