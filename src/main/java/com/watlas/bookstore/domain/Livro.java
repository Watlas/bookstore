package com.watlas.bookstore.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Livro implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotEmpty(message = "Campo TITULO vazio")
    @Length(min = 3, max = 100, message = "o campo TITULO deve ter entre 3 e 100 caracteres")
    private String titulo;


    @NotEmpty(message = "Campo NOME DO AUTOR vazio")
    @Length(min = 3, max = 100, message = "o campo NOME DO AUTOR deve ter entre 3 e 100 caracteres")
    private String nome_autor;


    @NotEmpty(message = "Campo TEXTO vazio")
    @Length(min = 3, max = 1000000, message = "o campo TEXTO deve ter entre 3 e 1000 caracteres")
    private String texto;


    @JsonIgnore //protege contra serialização
    @ManyToOne
    @JoinColumn
    private Categoria categoria;

    public Livro() {
    }

    public Livro(Integer id, String titulo, String nome_autor, String texto, Categoria categoria) {
        this.id = id;
        this.titulo = titulo;
        this.nome_autor = nome_autor;
        this.texto = texto;
        this.categoria = categoria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNome_autor() {
        return nome_autor;
    }

    public void setNome_autor(String nome_autor) {
        this.nome_autor = nome_autor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return Objects.equals(id, livro.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
