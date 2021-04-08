package br.edu.fafic.backendlibrary.resource;

import br.edu.fafic.backendlibrary.domain.Usuario;
import br.edu.fafic.backendlibrary.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioResource {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping()
    public ResponseEntity create(@RequestBody Usuario usuario) {
        return ResponseEntity.ok().body(usuarioService.create(usuario));
    }

    @GetMapping
    public ResponseEntity show(){
        return ResponseEntity.ok().body(usuarioService.show());
    }
}
