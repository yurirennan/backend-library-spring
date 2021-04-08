package br.edu.fafic.backendlibrary.repository;

import br.edu.fafic.backendlibrary.domain.Bibliotecario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BibliotecarioRepository extends JpaRepository<Bibliotecario, UUID> {
}
