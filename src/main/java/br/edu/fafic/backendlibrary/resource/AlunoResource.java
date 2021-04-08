package br.edu.fafic.backendlibrary.resource;

import br.edu.fafic.backendlibrary.domain.Aluno;
import br.edu.fafic.backendlibrary.dto.AlunoDTO;
import br.edu.fafic.backendlibrary.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoResource {

    @Autowired
    private AlunoService alunoService;

    @PostMapping
    public ResponseEntity create(@RequestBody Aluno aluno) {
        try {
            alunoService.create(aluno);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception err) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    public  ResponseEntity show() {
        return ResponseEntity.ok().body(alunoService.show());
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody AlunoDTO aluno, @PathVariable("id") UUID id) {
        try {
            this.alunoService.update(id,aluno);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception err) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") UUID id) {
        try {
            this.alunoService.delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception err) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity listByNome(@PathVariable("nome") String nome) {
        try {
            this.alunoService.listByNome(nome);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception err) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err.getMessage());
        }
    }

    @GetMapping("/matricula/{matricula}")
    public ResponseEntity listByMatricula(@PathVariable("matricula") String matricula) {
        try {
            this.alunoService.listByMatricula(matricula);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception err) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err.getMessage());
        }
    }
}
