package com.watlas.bookstore.dtos;

import com.watlas.bookstore.domain.Categoria;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class CategoriaDTO implements Serializable {

    private static final long serialVersionUID = 1l;

    private Integer id;
    @NotEmpty(message = "Campo NOME vazio")
    @Length(min = 3, max = 100, message = "o campo nome deve ter entre 3 e 10 caracteres")
    private String nome;
    @NotEmpty(message = "Campo Descricao vazio")
    @Length(min = 3, max = 100, message = "o campo Descricao deve ter entre 3 e 10 caracteres")
    private String descricao;

    public CategoriaDTO() {
        super();
    }

    public CategoriaDTO(Categoria obj) {
        super();
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.descricao = obj.getDescricao();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
