package com.watlas.bookstore.services;

import com.watlas.bookstore.domain.Categoria;
import com.watlas.bookstore.dtos.CategoriaDTO;
import com.watlas.bookstore.repositories.CategoriaRepository;
import com.watlas.bookstore.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;


@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository repository;

    //aqui cria o servico, o metodo que utilizaremos lá na resources
    public Categoria findById(Integer id) {
        Optional<Categoria> obj = repository.findById(id);   //aqui eu uso o metodo da Repository, interface
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID:" + id + " Tipo: " + Categoria.class.getName()));
    }

    public List<Categoria> findAll() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "colName"));
    }

    public Categoria create(Categoria obj) {
        obj.setId(null);
        return repository.save(obj);
    }

    public Categoria update(Integer id, CategoriaDTO objDTO) {
        Categoria obj = findById(id);
        obj.setNome(objDTO.getNome());
        obj.setDescricao(objDTO.getDescricao());
        return repository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);
        try {
            repository.deleteById(id);
        }catch (DataIntegrityViolationException e){
        throw new com.watlas.bookstore.services.exceptions.DataIntegrityViolationException("Category cannot be deleted, has associated books");
        }
    }
}
