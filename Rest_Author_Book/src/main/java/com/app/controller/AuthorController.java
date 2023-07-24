package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AuthDto;
import com.app.dto.AuthUpdateDto;
import com.app.dto.ResponseDto;
import com.app.dto.insertAuthDto;
import com.app.entity.Author;
import com.app.service.AuthorService;

@RestController
@RequestMapping("/author")
public class AuthorController {
	
	public AuthorController() {
		System.out.println("AuthorController started");
	}
	
	@Autowired
	private AuthorService authservice;
	
	@PostMapping("/insertAuthor")
	public ResponseDto insertAuthor(@RequestBody insertAuthDto dto)
	{
		return authservice.insertAuth(dto);
	}
	
	@GetMapping
	public List<Author> getAllAuths()
	{
		return authservice.getAllAuth();
	}
	
	@GetMapping("/{authId}")
	public AuthDto getAuthorById(@PathVariable int authId)
	{
		return authservice.getAuthByid(authId);
	}
	
	@DeleteMapping("/{authId}")
	public ResponseDto deleteAuthor(@PathVariable int authId)
	{
		return authservice.deleteAuthById(authId);
	}
	
	@PutMapping("/update")
	public ResponseDto updateAuth(@RequestBody AuthUpdateDto dto)
	{
		return authservice.updateAuth(dto);
	}
	
	@GetMapping("/auth/{authName}")
	public Author AuthByName(@PathVariable String authName)
	{
		return authservice.getAuthByName1(authName);
	}
	
	
	

}
