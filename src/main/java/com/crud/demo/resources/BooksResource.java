package com.crud.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.demo.model.Book;
import com.crud.demo.repository.BooksRepository;

@RestController
@RequestMapping(value="/rest/books")
public class BooksResource {

	@Autowired
	BooksRepository booksRepository;
	
	@GetMapping(value="/all")
	private List<Book> getAllBooks(){
		return booksRepository.findAll();
	}
	
	@PostMapping(value="/load")
	public List<Book> persist(@RequestBody final Book book){
		booksRepository.save(book);
		return booksRepository.findAll();
	}
	
//	@RequestMapping("/")
//    String welcome(){
//        return "welcome";
//    }
	
}
