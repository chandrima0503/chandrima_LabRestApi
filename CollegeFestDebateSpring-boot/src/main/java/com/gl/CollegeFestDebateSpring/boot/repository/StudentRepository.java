package com.gl.CollegeFestDebateSpring.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.CollegeFestDebateSpring.boot.entity.Student;

//service layer interface
@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{
	
}
