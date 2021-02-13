package com.watlas.bookstore.services;

import com.watlas.bookstore.domain.Categoria;
import com.watlas.bookstore.domain.Livro;
import com.watlas.bookstore.repositories.CategoriaRepository;
import com.watlas.bookstore.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBservice {

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private LivroRepository livroRepository;

    public void instanciaBaseDeDados(){
        Categoria ca1 = new Categoria(null, "informatica", "livros de ti");

        Livro l1 = new Livro(null, "Clean Code", "Watlas", "lorem ipsum", ca1);

        ca1.getLivros().addAll(Arrays.asList(l1));

        this.categoriaRepository.saveAll(Arrays.asList(ca1));
        this.livroRepository.saveAll(Arrays.asList(l1));
    }
}
