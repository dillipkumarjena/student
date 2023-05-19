package com.sg.service;

import com.sg.entity.Marks;
import com.sg.entity.Student;

public interface StudentService {

	public Student saveStudent(Student student);
	
	public Student updateMarks(int id, Marks marks);

}
