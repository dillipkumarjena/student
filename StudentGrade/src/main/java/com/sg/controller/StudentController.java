package com.sg.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.sg.entity.Marks;
import com.sg.entity.Student;
import com.sg.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/")
	public ModelAndView studentForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("student_form");
		return mav;

	}

	@PostMapping("/createStudent")
	public ResponseEntity<Student> createStudent(@Valid @RequestBody Student student) {

		try {
			student = studentService.saveStudent(student);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ResponseEntity.ok().body(student);
	}

	@PutMapping("/updateMarks/{id}")
	public ResponseEntity<Student> updateMarks(@PathVariable int id, @Valid @RequestBody Marks marks) {
		Student student = null;
		try {
			student = studentService.updateMarks(id, marks);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok().body(student);
	}
}
