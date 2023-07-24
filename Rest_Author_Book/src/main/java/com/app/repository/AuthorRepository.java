package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer>{
	
	Optional<Author> findByName(String authName);

}
