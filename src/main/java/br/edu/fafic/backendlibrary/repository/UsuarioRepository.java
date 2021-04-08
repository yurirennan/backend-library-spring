package br.edu.fafic.backendlibrary.repository;

import br.edu.fafic.backendlibrary.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
    Optional<Usuario> findByCpf(String cpf);

    @Query(value = "SELECT tipo_usuario FROM usuario WHERE usuario.id = ?1", nativeQuery = true)
    String findTypeOfUser(UUID id);
}
