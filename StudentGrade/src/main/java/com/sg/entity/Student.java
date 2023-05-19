package com.sg.entity;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;
import com.sg.en.Gender;
import com.sg.en.Section;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {
	private static final long serialVersionUID = 3848902775174847609L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank(message = "First Name is required")
	@Size(min = 3, message = "First Name should have atleast 3 characters")
	private String firstName;

	@NotBlank(message = "Last Name is required")
	@Size(min = 3, message = "Last Name should have atleast 3 characters")
	private String lastName;

	@NotNull(message = "DOB is required")
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	// @Min(value = 15, message = "Age should be greater than 15 year")
	// @Max(value = 20, message = "Age should be less than or equal 20 year")
	private LocalDate dob;

	private Section section;
	private Gender gender;

	@Min(value = 0, message = "Marks should not be less than 0")
	@Max(value = 100, message = "Marks should not be greater than 100")
	private int marks1;

	@Min(value = 0, message = "Marks should not be less than 0")
	@Max(value = 100, message = "Marks should not be greater than 100")
	private int marks2;

	@Min(value = 0, message = "Marks should not be less than 0")
	@Max(value = 100, message = "Marks should not be greater than 100")
	private int marks3;

	private int total;
	private float average;
	private String result;
}
