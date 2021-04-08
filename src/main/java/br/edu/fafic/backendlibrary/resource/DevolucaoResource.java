package br.edu.fafic.backendlibrary.resource;

import br.edu.fafic.backendlibrary.domain.Devolucao;
import br.edu.fafic.backendlibrary.service.DevolucaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/devolucao")
public class DevolucaoResource {

    @Autowired
    private DevolucaoService devolucaoService;

    @PostMapping
    public ResponseEntity create(@RequestBody Devolucao devolucao) {
        try {
            devolucaoService.create(devolucao);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception err) {
            System.out.println(err);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity show() {
        return ResponseEntity.ok().body(this.devolucaoService.show());
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestBody Devolucao devolucao) {
        try {
            devolucaoService.delete(devolucao);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception err) {
            System.out.println(err);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err.getMessage());
        }
    }
}
