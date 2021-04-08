package br.edu.fafic.backendlibrary.resource;

import br.edu.fafic.backendlibrary.domain.Emprestimo;
import br.edu.fafic.backendlibrary.domain.Professor;
import br.edu.fafic.backendlibrary.dto.ProfessorDTO;
import br.edu.fafic.backendlibrary.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/professores")
public class ProfessorResource {

    @Autowired
    private ProfessorService professorService;

    @PostMapping
    public ResponseEntity create(@RequestBody Professor professor){
        try {
            this.professorService.create(professor);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception err) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    public ResponseEntity show() {
        return ResponseEntity.ok().body(this.professorService.show());
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody ProfessorDTO professorDTO, @PathVariable("id") UUID id) {
        try {
            this.professorService.update(id,professorDTO);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception err) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") UUID id, @RequestBody Emprestimo emprestimo) {
        try {
            this.professorService.delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception err) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity listByNome(@PathVariable("nome") String nome) {
        try {
            this.professorService.listByNome(nome);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception err) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err.getMessage());
        }
    }

    @GetMapping("/matricula/{matricula}")
    public ResponseEntity listByMatricula(@PathVariable("matricula") String matricula) {
        try {
            this.professorService.listByMatricula(matricula);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception err) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err.getMessage());
        }
    }
}
