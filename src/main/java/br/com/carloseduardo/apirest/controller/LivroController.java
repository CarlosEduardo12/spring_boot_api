package br.com.carloseduardo.apirest.controller;


import br.com.carloseduardo.apirest.controller.dto.LivroResponse;
import br.com.carloseduardo.apirest.repository.LivroRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
