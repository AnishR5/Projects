package com.app.entity;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "book")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Book extends BaseEntity {
	@Column(length = 30,nullable = false,unique = true)
	private String title;
	@Column(nullable = false)
	private double price;
	@ManyToOne
	@JoinColumn(name = "authorId",nullable = false)
	private Author authorId;
	
	public Book(String title, double price) {
		super();
		this.title = title;
		this.price = price;
	}
	
//	public int getAuthorId()
//	{
//		return authorId.getId();
//	}
	
	
}
