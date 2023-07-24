package com.app.dto;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.app.entity.Author;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookinsertDto {
	
	private String title;
	private double price;
	private int authorId;

}
