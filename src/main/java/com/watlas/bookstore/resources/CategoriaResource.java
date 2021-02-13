package com.watlas.bookstore.resources;

import com.watlas.bookstore.domain.Categoria;
import com.watlas.bookstore.services.CategoriaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaServices services;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Integer id){
        Categoria obj = services.findById(id);
        return ResponseEntity.ok().body(obj);

    }
}
