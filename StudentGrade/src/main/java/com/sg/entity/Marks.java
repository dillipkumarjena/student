package com.sg.entity;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Marks implements Serializable{
	private static final long serialVersionUID = -7587766302576053690L;

	@Min(value = 0, message = "Marks should not be less than 0")
	@Max(value = 100, message = "Marks should not be greater than 100")
	private int marks1;

	@Min(value = 0, message = "Marks should not be less than 0")
	@Max(value = 100, message = "Marks should not be greater than 100")
	private int marks2;

	@Min(value = 0, message = "Marks should not be less than 0")
	@Max(value = 100, message = "Marks should not be greater than 100")
	private int marks3;
}
