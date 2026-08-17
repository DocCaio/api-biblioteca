package com.biblioteca.api_biblioteca.controller;


import com.biblioteca.api_biblioteca.model.Livro;
import com.biblioteca.api_biblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroRepository repository;

    @GetMapping
    public List<Livro> listarTodos() {
        return repository.findAll();
    }

    @PostMapping
    public Livro salvar(@RequestBody Livro livro) {
        return repository.save(livro);
    }

}
