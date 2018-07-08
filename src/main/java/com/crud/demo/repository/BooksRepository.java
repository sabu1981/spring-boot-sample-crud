package com.crud.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.crud.demo.model.Book;

public interface BooksRepository extends JpaRepository<Book, Integer>{
	
	 @Query("SELECT l FROM Book l WHERE l.autor = :autor")
	 public Book findByAutor(@Param("autor") String autor);
	 
	 @Query("SELECT l FROM Book l WHERE l.titulo = :titulo")
	 public Book findByTitulo(@Param("titulo") String titulo);
	 
	 @Query("SELECT l FROM Book l WHERE l.autor = :autor and l.titulo = :titulo")
	 public Book findByAutorAndTitulo(@Param("autor") String autor, @Param("titulo") String titulo);

}
