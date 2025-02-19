package com.pw.pw.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pw.pw.entity.Student;

import jakarta.persistence.EntityManager;



public interface StdRepo extends JpaRepository<Student, Integer> {

}
