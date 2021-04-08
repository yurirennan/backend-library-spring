package br.edu.fafic.backendlibrary.service;

import br.edu.fafic.backendlibrary.domain.Aluno;
import br.edu.fafic.backendlibrary.domain.Professor;
import br.edu.fafic.backendlibrary.dto.AlunoDTO;
import br.edu.fafic.backendlibrary.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    @Autowired
    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public Aluno create(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public List<Aluno> show() {
        return alunoRepository.findAll();
    }

    public Aluno update(UUID id, AlunoDTO aluno) throws Exception {
        Aluno alunoExistente = this.alunoRepository.findById(id).orElseThrow(() -> new Exception());

        alunoExistente.setNome(aluno.getNome());
        alunoExistente.setCurso(aluno.getCurso());
        alunoExistente.setPeriodoCurso(aluno.getPeriodoCurso());
        alunoExistente.setContato(aluno.getContato());
        alunoExistente.setEndereco(aluno.getEndereco());
        alunoExistente.setGenero(aluno.getGenero());

        return this.alunoRepository.save(alunoExistente);
    }

    public void delete(UUID id) throws Exception {
        Aluno alunoExistente = this.alunoRepository.findById(id).orElseThrow(() -> new Exception());
        this.alunoRepository.delete(alunoExistente);
    }

    public Aluno listByMatricula(String matricula) throws Exception {
        if(this.alunoRepository.findByMatricula(matricula).isEmpty()) {
            throw new Exception("Aluno não cadastrado");
        }

        return this.alunoRepository.findByMatricula(matricula).get();
    }

    public Aluno listByNome(String nome) throws Exception {
        if(this.alunoRepository.findByNome(nome).isEmpty()) {
            throw new Exception("Aluno não cadastrado");
        }

        return this.alunoRepository.findByNome(nome).get();
    }
}
