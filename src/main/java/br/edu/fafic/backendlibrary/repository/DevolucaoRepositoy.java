package br.edu.fafic.backendlibrary.repository;

import br.edu.fafic.backendlibrary.domain.Devolucao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DevolucaoRepositoy extends JpaRepository<Devolucao, UUID> { }
