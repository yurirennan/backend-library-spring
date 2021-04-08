package br.edu.fafic.backendlibrary.repository;

import br.edu.fafic.backendlibrary.domain.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AlunoRepository extends JpaRepository<Aluno, UUID> {
    Optional<Aluno> findByNome(String nome);
    Optional<Aluno> findByMatricula(String matricula);
}
