package com.app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookUpdateDto {
	
	private int id;
	private String title;
	private double price;
	private int courseId;

}
