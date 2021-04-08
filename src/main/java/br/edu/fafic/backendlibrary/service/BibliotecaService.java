package br.edu.fafic.backendlibrary.service;

import br.edu.fafic.backendlibrary.domain.Biblioteca;
import br.edu.fafic.backendlibrary.repository.BibliotecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BibliotecaService {
    private final BibliotecaRepository bibliotecaRepository;

    @Autowired
    public BibliotecaService(BibliotecaRepository bibliotecaRepository) {
        this.bibliotecaRepository = bibliotecaRepository;
    }

    public void create(Biblioteca biblioteca){
        bibliotecaRepository.save(biblioteca);
    }

    public List<Biblioteca> show(){
        return bibliotecaRepository.findAll();
    }

}
