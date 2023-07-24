package com.app.service;

import java.util.List;

import com.app.dto.AuthDto;
import com.app.dto.AuthUpdateDto;
import com.app.dto.ResponseDto;
import com.app.dto.insertAuthDto;
import com.app.entity.Author;

public interface AuthorService {
	
	ResponseDto insertAuth(insertAuthDto dto);
	
	List<Author> getAllAuth();
	
	AuthDto getAuthByid(int authId);
	
	ResponseDto deleteAuthById(int authId);
	ResponseDto updateAuth(AuthUpdateDto dto);
	
	Author getAuthByName1(String authName);

}
