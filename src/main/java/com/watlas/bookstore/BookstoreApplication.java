package com.watlas.bookstore;

import com.watlas.bookstore.domain.Categoria;
import com.watlas.bookstore.domain.Livro;
import com.watlas.bookstore.repositories.CategoriaRepository;
import com.watlas.bookstore.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class BookstoreApplication{

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

}
