package com.biblioteca.api_biblioteca.repository;

import com.biblioteca.api_biblioteca.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}