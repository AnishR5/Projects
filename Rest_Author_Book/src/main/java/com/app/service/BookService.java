package com.app.service;

import java.util.List;

import com.app.dto.BookDto;
import com.app.dto.BookUpdateDto;
import com.app.dto.BookinsertDto;
import com.app.dto.ResponseDto;
import com.app.entity.Book;

public interface BookService {
	
	ResponseDto insertBook(BookinsertDto dto);
	
	List<Book> getAllBooks();
	
	BookDto getBookById(int bookID);
	
	ResponseDto updateBook(BookUpdateDto dto);
	
	ResponseDto deleteBook(int bookid);

}
