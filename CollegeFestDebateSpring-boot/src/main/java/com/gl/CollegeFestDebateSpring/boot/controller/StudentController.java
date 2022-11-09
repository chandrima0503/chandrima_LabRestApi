package com.gl.CollegeFestDebateSpring.boot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.CollegeFestDebateSpring.boot.entity.Student;
import com.gl.CollegeFestDebateSpring.boot.service.StudentService;

//here /students is the common relative mapping for all URI
@Controller
@RequestMapping("/students")
public class StudentController {
	@Autowired
	StudentService studentService;
	
	//Mapping for /students/list
	@RequestMapping("/list")
	public String StudentList(Model model)
	{
		List<Student> students=studentService.getAllStudents();
		model.addAttribute("students", students);
		return "list-students";
	}
	
	//Mapping for /students/showFormForAdd
	@RequestMapping("/showFormForAdd")
	public String addStudent(Model model)
	{
		Student student=new Student();
		model.addAttribute("student",student);
		return "student-form";
	}
	
	//Mapping for /students/save
	@RequestMapping("/save")
	public String saveStudent(@RequestParam("id") int id,
			@RequestParam("firstname") String firstname,
			@RequestParam("lastname") String lastname,
			@RequestParam("department") String department,
			@RequestParam("country") String country)
	{
		System.out.println(id);
		
		if (id != 0) {
			Optional<Student> student;
			student = studentService.findById(id);
			student.get().setFirstname(firstname);
			student.get().setLastname(lastname);
			student.get().setDepartment(department);
			student.get().setCountry(country);
			studentService.save(student.get());
		} else
		{
			Student student = new Student(id, firstname, lastname, department, country);
		// save the Student
			studentService.save(student);
		}
		// using a redirect to prevent duplicate submissions
		return "redirect:/students/list";
	}
	
	//Mapping for /students/update
	@RequestMapping("/update")
	public String updateStudent(@RequestParam("studentId") int id,Model model)
	{
		Optional<Student> student = studentService.findById(id);
		model.addAttribute("student", student.get());
		return "student-form";
	}
	
	//Mapping for /students/delete
	@RequestMapping("/delete")
	public String deleteStudent(@RequestParam("studentId") int id,Model model)
	{
		Optional<Student> student = studentService.findById(id);
		studentService.delete(student.get());
		return "redirect:/students/list";
	}
	@RequestMapping("/403")
	public String noAccess()
	{
		return "error";
	}

}
