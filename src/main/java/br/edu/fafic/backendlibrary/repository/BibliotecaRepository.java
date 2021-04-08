package br.edu.fafic.backendlibrary.repository;

import br.edu.fafic.backendlibrary.domain.Biblioteca;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BibliotecaRepository extends JpaRepository<Biblioteca, UUID> {
}
