package com.crud.demo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.crud.demo.model.Book;
import com.crud.demo.repository.BooksRepository;

@Controller
public class LogicResource {
	
	@Autowired
	BooksRepository booksRepository;
	
	@RequestMapping(value ="/books/list", method = RequestMethod.GET)
	private String getAllBooks(Model model){
		 model.addAttribute("books", booksRepository.findAll());
	     System.out.println("Returning books:");
	     return "books";
	}
	
	@PostMapping("/books/search")
	private String searchBook(@ModelAttribute Book book, Model model){
		 System.out.println("------------------------ " +book.toString());
		 Book bookReturn = null;
		 if ((book.getAutor() != null && !book.getAutor().isEmpty()) &&
				 (book.getTitulo() == null || book.getTitulo().isEmpty())) {
			 System.out.println("Busqueda por AUTOR");
			 bookReturn = booksRepository.findByAutor(book.getAutor());
		 } else if ((book.getAutor() == null || book.getAutor().isEmpty()) &&
				 (book.getTitulo() != null && !book.getTitulo().isEmpty())) {
			 System.out.println("Busqueda por TITULO");
			 bookReturn = booksRepository.findByTitulo(book.getTitulo());
		 } else if ((book.getAutor() != null && !book.getAutor().isEmpty()) &&
				 (book.getTitulo() != null && !book.getTitulo().isEmpty())) {
			 System.out.println("Busqueda por AUTORY y TITULO");
			 bookReturn = booksRepository.findByAutorAndTitulo(book.getAutor(), book.getTitulo());
		 } else {
			System.out.println("Nada que mostrar"); 
		 }
		 model.addAttribute("books", bookReturn);
	     System.out.println("Returning books:");
	     return "books";
	}
	
}
