package com.app.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.BookDto;
import com.app.dto.BookUpdateDto;
import com.app.dto.BookinsertDto;
import com.app.dto.ResponseDto;
import com.app.entity.Author;
import com.app.entity.Book;
import com.app.repository.AuthorRepository;
import com.app.repository.BookRepository;

@Service
@Transactional
public class BookServiceImpl implements BookService {
	
	public BookServiceImpl() {
		System.out.println("Book service Stared");
	}
	
	@Autowired
	private BookRepository bkRepo;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private AuthorRepository athRepo;
	@Override
	
	public ResponseDto insertBook(BookinsertDto dto) {
		Book book=mapper.map(dto, Book.class);
		Author author=athRepo.findById(dto.getAuthorId()).orElseGet(null);
		author.insertBook(book);
		bkRepo.save(book);
		return new ResponseDto("New Book Added");
	}
	@Override
	public List<Book> getAllBooks() {
		
		return bkRepo.findAll();
		}
	@Override
	public BookDto getBookById(int bookID) {
		Book book=bkRepo.findById(bookID).orElseThrow(null);
		return mapper.map(book, BookDto.class);
	}
	@Override
	public ResponseDto updateBook(BookUpdateDto dto) {
		Book book=mapper.map(dto, Book.class);
		Author author=athRepo.findById(dto.getCourseId()).orElseThrow(null);
		
		bkRepo.save(book);
		return new ResponseDto("Book updated Succesfully");
	}
	@Override
	public ResponseDto deleteBook(int bookid) {
		Book b=bkRepo.findById(bookid).orElseThrow(null);
		Author auth=athRepo.findById(b.getAuthorId().getId()).orElseThrow(null);
		auth.deleteBook(b);
		bkRepo.delete(b);
		return new ResponseDto("Book deleted");
	}
	
	
	

}
