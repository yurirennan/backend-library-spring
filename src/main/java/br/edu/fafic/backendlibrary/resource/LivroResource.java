package br.edu.fafic.backendlibrary.resource;

import br.edu.fafic.backendlibrary.domain.Livro;
import br.edu.fafic.backendlibrary.dto.LivroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.edu.fafic.backendlibrary.service.LivroService;

import java.util.UUID;

@RestController
@RequestMapping(value = "/livros")
public class LivroResource {

    @Autowired
    private LivroService livroService;

    @PostMapping()
    public ResponseEntity save(@RequestBody Livro livro){
        try {
            return ResponseEntity.ok().body(this.livroService.saveLivro(livro));
        } catch (Exception err) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity show() {
        return ResponseEntity.ok().body(livroService.show());
    }

    @GetMapping("/isbn/{isbn}")
    public ResponseEntity listByIsbn(@PathVariable("isbn") String isbn) {
        try {
            return ResponseEntity.ok().body(this.livroService.listByIsbn(isbn));
        } catch (Exception err) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err.getMessage());
        }
    }

    @GetMapping("/area/{area}")
    public ResponseEntity listByArea(@PathVariable("area") Integer area) {
        try {
            return ResponseEntity.ok().body(this.livroService.listByArea(area));
        } catch (Exception err) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err.getMessage());
        }
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity listByNome(@PathVariable("nome") String nome) {
        try {
            return ResponseEntity.ok().body(this.livroService.listbyNome(nome));
        } catch (Exception err) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody LivroDTO livroDTO, @PathVariable("id") UUID id){
        try {
            this.livroService.update(id, livroDTO);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception err) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") UUID id) {
        try {
            this.livroService.delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception err) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err.getMessage());
        }
    }

}
