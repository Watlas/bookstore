package com.watlas.bookstore.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.watlas.bookstore.dtos.CategoriaDTO;
import com.watlas.bookstore.dtos.LivroDTO;
import com.watlas.bookstore.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.watlas.bookstore.domain.Livro;
import com.watlas.bookstore.services.LivroService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/livros")
public class LivroResource {

    @Autowired
    private LivroService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Livro> findById(@PathVariable Integer id) {
        Livro obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    @GetMapping
    public ResponseEntity<List<LivroDTO>> findAll(@RequestParam(value = "categoria", defaultValue = "0") Integer id_cat){
        //localhost:8080/livro?categoria=1 --URl
        List<Livro> list = service.findAll(id_cat);
        List<LivroDTO> listDTO = list.stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Livro> update(@PathVariable Integer id, @RequestBody Livro obj){
        Livro newobj = service.update(id, obj);
        return ResponseEntity.ok().body(newobj);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Livro> updatePatch(@PathVariable Integer id, @RequestBody Livro obj){
        Livro newobj = service.update(id, obj);
        return ResponseEntity.ok().body(newobj);
    }
    @PostMapping
    public ResponseEntity<Livro> create(@RequestParam(value = "categoria", defaultValue = "0") Integer idcat, @RequestBody Livro obj){
        Livro newObj = service.create(idcat, obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/livro/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
