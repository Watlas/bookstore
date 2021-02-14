package com.watlas.bookstore.services;

import com.watlas.bookstore.domain.Categoria;
import com.watlas.bookstore.domain.Livro;
import com.watlas.bookstore.repositories.LivroRepository;
import com.watlas.bookstore.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repository;

    @Autowired
    private CategoriaService categoriaService;

    public Livro findById(Integer id){
        Optional<Livro> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Book not found! id," + id + " Tipo" + Livro.class.getName()));
    }

    public List<Livro> findAll(Integer id_cat) {
        categoriaService.findById(id_cat);
        return repository.findByCategoria(id_cat);
    }

    public Livro update(Integer id, Livro obj) {
        Livro newObj = findById(id);
        updateData(newObj, obj);
        return repository.save(newObj);
    }

    private void updateData(Livro newObj, Livro obj) {
        newObj.setTitulo(obj.getTitulo());
        newObj.setNome_autor(obj.getNome_autor());
        newObj.setTexto(obj.getTexto());

    }

    public Livro create(Integer idcat, Livro obj) {
        obj.setId(null);
        Categoria cat = categoriaService.findById(idcat);
        obj.setCategoria(cat);
        return repository.save(obj);
    }

    public void delete(Integer id) {
        Livro obj = findById(id);
        repository.delete(obj);
    }
}
