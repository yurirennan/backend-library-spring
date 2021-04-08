package br.edu.fafic.backendlibrary.service;

import br.edu.fafic.backendlibrary.domain.Usuario;
import br.edu.fafic.backendlibrary.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario create(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> show(){
        return usuarioRepository.findAll();
    }
}
