package com.app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BookDto {
	
	private int id;
	private String title;
	private double price;
	//private int authorId;
	public BookDto(int id, String title, double price) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
	}
	
	

}
