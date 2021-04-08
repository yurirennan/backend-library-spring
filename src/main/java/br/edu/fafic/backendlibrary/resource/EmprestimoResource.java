package br.edu.fafic.backendlibrary.resource;

import br.edu.fafic.backendlibrary.domain.Emprestimo;
import br.edu.fafic.backendlibrary.service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/emprestimos")
public class EmprestimoResource {

    @Autowired
    private EmprestimoService emprestimoService;

    @PostMapping
    public ResponseEntity create(@RequestBody Emprestimo emprestimo, @RequestHeader("bibliotecario_id") UUID id) {
        try {
            emprestimoService.create(emprestimo);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception err) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity show() {
        return ResponseEntity.ok().body(this.emprestimoService.show());
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestBody Emprestimo emprestimo) {
        try {
            emprestimoService.delete(emprestimo);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception err) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err.getMessage());
        }
    }
}
