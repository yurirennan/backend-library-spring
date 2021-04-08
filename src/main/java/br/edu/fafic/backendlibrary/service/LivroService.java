package br.edu.fafic.backendlibrary.service;

import br.edu.fafic.backendlibrary.domain.Livro;
import br.edu.fafic.backendlibrary.dto.LivroDTO;
import br.edu.fafic.backendlibrary.repository.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.fafic.backendlibrary.repository.LivroRepository;

import java.util.List;
import java.util.UUID;

@Service
public class LivroService {
    private final LivroRepository livroRepository;
    private final EmprestimoRepository emprestimoRepository;

    @Autowired
    public LivroService(LivroRepository livroRepository, EmprestimoRepository emprestimoRepository) {
        this.livroRepository = livroRepository;
        this.emprestimoRepository = emprestimoRepository;
    }

    public Livro saveLivro(Livro livro) throws Exception {
        Livro livro1 = this.livroRepository.findByIsbn(livro.getIsbn());

        if (livro1 != null) {
            throw new Exception("Livro com isbn já cadastrado!");
        }

        return livroRepository.save(livro);
    }

    public List<Livro> show() {
        return livroRepository.findAll();
    }

    public Livro listByIsbn(String isbn) throws Exception {
        Livro livro = livroRepository.findByIsbn(isbn);

        if (livro == null) {
            throw new Exception("Livro não cadastrado!");
        }

        return livro;
    }

    public List<Livro> listByArea(Integer area) throws Exception {
        List<Livro> livros = this.livroRepository.findAllByArea(area);

        if (livros.isEmpty()) {
            throw new Exception("Livro não cadastrado!");
        }

        return livros;
    }

    public List<Livro> listbyNome(String nome) throws Exception {
        List<Livro> livros = this.livroRepository.findAllByNome(nome);

        if (livros.isEmpty()) {
            throw new Exception("Livro não cadastrado!");
        }

        return livros;
    }



    public void update(UUID id, LivroDTO livroDTO) throws Exception {
        Livro livro = this.livroRepository.findById(id).orElseThrow(() -> new Exception("Livro não cadastrado!"));

        livro.setNome(livroDTO.getNome());
        livro.setArea(livroDTO.getArea());

        this.livroRepository.save(livro);
    }

    public void delete(UUID id) throws Exception {
        Livro livro = this.livroRepository.findById(id).orElseThrow(() -> new Exception("Livro não cadastrado!"));

        this.livroRepository.delete(livro);
    }


}
