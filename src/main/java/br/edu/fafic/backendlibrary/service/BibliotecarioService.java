package br.edu.fafic.backendlibrary.service;

import br.edu.fafic.backendlibrary.domain.Bibliotecario;
import br.edu.fafic.backendlibrary.dto.BibliotecarioDTO;
import br.edu.fafic.backendlibrary.repository.BibliotecarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@Service
public class BibliotecarioService {

    private final BibliotecarioRepository bibliotecarioRepository;

    @Autowired
    public BibliotecarioService(BibliotecarioRepository bibliotecarioRepository) {
        this.bibliotecarioRepository = bibliotecarioRepository;
    }

    public void create(Bibliotecario bibliotecario) {
        this.bibliotecarioRepository.save(bibliotecario);
    }

    public List<Bibliotecario> show() {
        return this.bibliotecarioRepository.findAll();
    }

    public void update(UUID id, BibliotecarioDTO bibliotecarioDTO) throws Exception{
        Bibliotecario bibliotecario = this.bibliotecarioRepository.findById(id).orElseThrow(() -> new Exception());

        bibliotecario.setNome(bibliotecarioDTO.getNome());
        bibliotecario.setGenero(bibliotecarioDTO.getGenero());
        bibliotecario.setEndereco(bibliotecarioDTO.getEndereco());
        bibliotecario.setContato(bibliotecarioDTO.getContato());

        this.bibliotecarioRepository.save(bibliotecario);
    }

    public void delete(UUID id) throws Exception {
        Bibliotecario bibliotecario = this.bibliotecarioRepository.findById(id).orElseThrow(() -> new Exception());

        this.bibliotecarioRepository.delete(bibliotecario);
    }
}
