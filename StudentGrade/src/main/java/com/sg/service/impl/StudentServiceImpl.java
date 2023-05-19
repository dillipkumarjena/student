package com.sg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sg.entity.Marks;
import com.sg.entity.Student;
import com.sg.repo.StudentRepo;
import com.sg.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepo studentRepo;

	@Override
	public Student saveStudent(Student student) {

		try {
			if (student != null) {
				student.setTotal(totalMarks(student));
				student.setAverage(averageMarks(student));
				student.setResult(result(student));
				student = studentRepo.save(student);
			}
		} catch (Exception e) {
			System.out.println("Error occoured in saveStudent() in StudentService");
		}
		return student;
	}

	@Override
	public Student updateMarks(int id, Marks marks) {
		Student student = null;
		student = studentRepo.findById(id).orElse(null);
		student.setMarks1(marks.getMarks1());
		student.setMarks2(marks.getMarks2());
		student.setMarks3(marks.getMarks3());

		student.setTotal(totalMarks(student));
		student.setAverage(averageMarks(student));
		student.setResult(result(student));

		return studentRepo.save(student);
	}
	
	// Calculate total marks
	public int totalMarks(Student student) {
		int totalMarks = 0;

		totalMarks = student.getMarks1() + student.getMarks2() + student.getMarks3();
		return totalMarks;
	}
	
	// Calculate average
	public float averageMarks(Student student) {
		int totalMarks = 0;
		float average = 0.0f;
		totalMarks = totalMarks(student);
		average = totalMarks / 3.0f;
		return average;
	}

	// Calculate result
	public String result(Student student) {
		String result = "";
		if (student.getMarks1() >= 35 && student.getMarks2() >= 35 && student.getMarks3() >= 35)
			result = "Pass";
		else
			result = "Fail";
		return result;
	}
}
