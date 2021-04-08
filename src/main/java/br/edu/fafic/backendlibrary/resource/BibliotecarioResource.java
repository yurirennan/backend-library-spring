package br.edu.fafic.backendlibrary.resource;

import br.edu.fafic.backendlibrary.domain.Bibliotecario;
import br.edu.fafic.backendlibrary.dto.BibliotecarioDTO;
import br.edu.fafic.backendlibrary.service.BibliotecarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/bibliotecario")
public class BibliotecarioResource {
    @Autowired
    private BibliotecarioService bibliotecarioService;

    @PostMapping
    public ResponseEntity create(@RequestBody Bibliotecario bibliotecario) {
        try {
            this.bibliotecarioService.create(bibliotecario);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception err) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    public ResponseEntity show() {
        try {
            return ResponseEntity.ok().body(this.bibliotecarioService.show());
        } catch (Exception err) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody BibliotecarioDTO bibliotecarioDTO, @PathVariable("id") UUID id) {
        try {
            this.bibliotecarioService.update(id, bibliotecarioDTO);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception err) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") UUID id) {
        try {
            this.bibliotecarioService.delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception err) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }




}
