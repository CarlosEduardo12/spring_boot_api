package br.com.carloseduardo.apirest.controller;


import br.com.carloseduardo.apirest.controller.dto.LivroRequest;
import br.com.carloseduardo.apirest.controller.dto.LivroResponse;
import br.com.carloseduardo.apirest.model.Livro;
import br.com.carloseduardo.apirest.repository.LivroRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/livro")

public class LivroController {

    private final LivroRepository livroRepository;

    public LivroController(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }
    @GetMapping("/")
    public List<LivroResponse> findAll(){
    var livros = livroRepository.findAll();
    return livros
            .stream()
            .map(LivroResponse::converter)
            .collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    public LivroResponse findById(@PathVariable("id") Long id){
        var livro = livroRepository.getOne(id);
        return LivroResponse.converter(livro);
    }
    @PostMapping("/")
    public void saveLivro(@RequestBody LivroRequest livro){
        var l = new Livro();
        l.setNome(livro.getNome());
        l.setAutor(livro.getAutor());
        livroRepository.save(l);
    }
}
