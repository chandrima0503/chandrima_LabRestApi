package com.gl.CollegeFestDebateSpring.boot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.CollegeFestDebateSpring.boot.entity.Student;
import com.gl.CollegeFestDebateSpring.boot.repository.StudentRepository;

//Implementation for service interface


@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository studentRepository;

	
	//provide the list of all students
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	//find the student with the given id
	public Optional<Student> findById(int id) {
		return studentRepository.findById(id);
	}
	
	//save student data
	public Student save(Student student) {
		return studentRepository.saveAndFlush(student);

	}
	
	//delete student data
	public void delete(Student student) {
		studentRepository.delete(student);

	}

}
