package br.com.carloseduardo.apirest.repository;


import br.com.carloseduardo.apirest.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

}
