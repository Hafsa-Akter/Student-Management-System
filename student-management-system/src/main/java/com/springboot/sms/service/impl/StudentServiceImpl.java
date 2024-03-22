package com.springboot.sms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.sms.entity.Student;
import com.springboot.sms.repository.StudentRepository;
import com.springboot.sms.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	private StudentRepository studentRepo;
	
	public StudentServiceImpl(StudentRepository studentRepo) {
		super();
		this.studentRepo = studentRepo;
	}

	@Override
	public List<Student> getAllStudents() {
		
		return studentRepo.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		return studentRepo.save(student);
	}

	@Override
	public Student getStudentById(Long id) {
		return studentRepo.findById(id).get() ;
	}

	@Override
	public Student updateStudent(Student student) {
		return studentRepo.save(student);
	}

	@Override
	public void deleteStudentById(Long id) {
       studentRepo.deleteById(id);		
	}
	
	

}
