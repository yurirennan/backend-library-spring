package br.edu.fafic.backendlibrary.repository;

import br.edu.fafic.backendlibrary.domain.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, UUID> {
    List<Optional<Emprestimo>> findAllByUsuarioId(UUID id);

    @Query(value = "SELECT emprestimo_id FROM emprestimo_livros WHERE livros_id = ?1", nativeQuery = true)
    List<String> findAllEmprestimosByLivroId(UUID id);
}
