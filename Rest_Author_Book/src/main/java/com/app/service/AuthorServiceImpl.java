package com.app.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.AuthDto;
import com.app.dto.AuthUpdateDto;
import com.app.dto.ResponseDto;
import com.app.dto.insertAuthDto;
import com.app.entity.Author;
import com.app.repository.AuthorRepository;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {
	
	public AuthorServiceImpl() {
		System.out.println("AuthorService started");
	}
	
	@Autowired
	private AuthorRepository authRepo;
	@Autowired
	private ModelMapper mapper;

	@Override
	public ResponseDto insertAuth(insertAuthDto dto) {
		Author auth=mapper.map(dto, Author.class);
		authRepo.save(auth);
		return new ResponseDto("Author added succesfully");
	}

	@Override
	public List<Author> getAllAuth() {
		
		return authRepo.findAll();
	}

	@Override
	public AuthDto getAuthByid(int authId) {
		Author auth=authRepo.findById(authId).orElseThrow(null);
		return mapper.map(auth, AuthDto.class);
	}

	@Override
	public ResponseDto deleteAuthById(int authId) {
		authRepo.deleteById(authId);
		return new ResponseDto("Author deleted");
	}

	@Override
	public ResponseDto updateAuth(AuthUpdateDto dto) {
		Author ath=mapper.map(dto, Author.class);
		authRepo.save(ath);
		return new ResponseDto("Author updated");
	}

	@Override
	public Author getAuthByName1(String authName) {
		Author auth=authRepo.findByName(authName).orElseThrow(null);
		return auth;
	}

	
	

}
