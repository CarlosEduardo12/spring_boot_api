package br.com.carloseduardo.apirest.controller.dto;

import br.com.carloseduardo.apirest.model.Livro;

public class LivroResponse {

    private Long id;
    private String nome;
    private String autor;

    public static LivroResponse converter(Livro l){
        var livro = new LivroResponse();
        livro.setId(l.getId());
        livro.setNome(l.getNome());
        livro.setAutor(l.getAutor());

        return livro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
