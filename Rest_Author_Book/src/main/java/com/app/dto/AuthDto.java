package com.app.dto;

import java.util.List;

import com.app.entity.Book;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthDto {
	
	private String name;
	private String email;
	private int age;
	private List<Book> bookList;

}
