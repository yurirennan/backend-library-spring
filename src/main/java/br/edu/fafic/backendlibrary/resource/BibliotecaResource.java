package br.edu.fafic.backendlibrary.resource;

import br.edu.fafic.backendlibrary.domain.Biblioteca;
import br.edu.fafic.backendlibrary.dto.AlunoDTO;
import br.edu.fafic.backendlibrary.service.BibliotecaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/biblioteca")
public class BibliotecaResource {

    @Autowired
    private BibliotecaService bibliotecaService;

    @PostMapping
    public ResponseEntity create(@RequestBody Biblioteca biblioteca) {
        try {
            this.bibliotecaService.create(biblioteca);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception err){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
        }
    }

    @GetMapping
    public ResponseEntity show() {
        try {
            return ResponseEntity.ok().body(this.bibliotecaService.show());
        } catch (Exception err){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
