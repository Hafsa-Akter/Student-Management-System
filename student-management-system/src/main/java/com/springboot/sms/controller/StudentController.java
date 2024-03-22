package com.springboot.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.sms.entity.Student;
import com.springboot.sms.service.StudentService;

@Controller
public class StudentController {
	
	private StudentService service;
	
	public StudentController(StudentService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", service.getAllStudents());
		return"students";
	}

	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		Student student=new Student();
		model.addAttribute("student",student);
		return "create_student";
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		service.saveStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id,Model model) {
		model.addAttribute("student",service.getStudentById(id));
		return "edit_student";
	}
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id,@ModelAttribute("Student") Student student,Model model) {
		Student existedStudent=service.getStudentById(id);
		
		existedStudent.setId(id);
		existedStudent.setFirstName(student.getFirstName());
		existedStudent.setLastName(student.getLastName());
		existedStudent.setEmail(student.getEmail());
		service.updateStudent(existedStudent);
		return "redirect:/students";
	}
	
	
	@GetMapping("/students/{id}")
	
	public String deleteStudentByid(@PathVariable Long id) {
		service.deleteStudentById(id);
		return "redirect:/students";
	}

}
