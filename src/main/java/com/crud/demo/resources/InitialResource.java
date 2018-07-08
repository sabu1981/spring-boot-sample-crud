package com.crud.demo.resources;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crud.demo.model.Book;

@Controller
public class InitialResource {

	@RequestMapping("/")
    String index(){
        //return "welcome";
		return "index";
    }
	
	@RequestMapping(value ="/books/search")
    String search(Model model){
		model.addAttribute("book", new Book());
		return "bookSearch";
    }
}
