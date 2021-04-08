package br.edu.fafic.backendlibrary.repository;

import br.edu.fafic.backendlibrary.domain.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface LivroRepository extends JpaRepository<Livro, UUID> {
    Livro findByIsbn(String isbn);
    List<Livro> findAllByArea(Integer area);
    List<Livro> findAllByNome(String nome);
}
