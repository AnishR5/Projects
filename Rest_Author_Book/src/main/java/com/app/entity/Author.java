package com.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.*;


@Entity
@Table(name = "author")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Author extends BaseEntity {
	@Column(length = 30,nullable = false)
	private String name;
	@Column(length = 30,nullable = false,unique = true)
	private String email;
	@Column(nullable = false)
	private int age;
	@OneToMany(mappedBy = "authorId",cascade = CascadeType.ALL ,orphanRemoval = true,fetch = FetchType.EAGER)
	private List<Book> bookList=new ArrayList<>();
	
	public Author(String name, String email, int age) {
		super();
		this.name = name;
		this.email = email;
		this.age = age;
	}
	
	public void insertBook(Book book)
	{
		bookList.add(book);
		
		book.setAuthorId(this);
	}
	
	public void deleteBook(Book book)
	{
		bookList.remove(book);
	}
	
	
	
	
}
