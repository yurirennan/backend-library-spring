package br.edu.fafic.backendlibrary.repository;

import br.edu.fafic.backendlibrary.domain.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProfessorRepository extends JpaRepository<Professor, UUID> {
    Optional<Professor> findByNome(String nome);
    Optional<Professor> findByMatricula(String matricula);

}
