package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.BookDto;
import com.app.dto.BookUpdateDto;
import com.app.dto.BookinsertDto;
import com.app.dto.ResponseDto;
import com.app.entity.Book;
import com.app.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	
	public BookController() {
		System.out.println("Book Controller started");
	}
	
	@Autowired
	private BookService bkService;
	
	@PostMapping("/insert")
	public ResponseDto insertBook(@RequestBody BookinsertDto dto)
	{
		return bkService.insertBook(dto);
	}
	
	@GetMapping
	public List<Book> getAllBooks()
	{
		return bkService.getAllBooks();
	}
	
	@GetMapping("/{bookId}")
	public BookDto getBookById(@PathVariable int bookId)
	{
		return bkService.getBookById(bookId);
	}
	
//	@PutMapping("/update")
//	public ResponseDto updateBook(@RequestBody BookUpdateDto dto) {
//		return bkService.updateBook(dto);
//	}
	
	@DeleteMapping("/{bookId}")
	public ResponseDto deleteBook(@PathVariable int bookId)
	{
		return bkService.deleteBook(bookId);
	}
	
	

}
