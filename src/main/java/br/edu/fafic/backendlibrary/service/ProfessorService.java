package br.edu.fafic.backendlibrary.service;

import br.edu.fafic.backendlibrary.domain.Professor;
import br.edu.fafic.backendlibrary.dto.ProfessorDTO;
import br.edu.fafic.backendlibrary.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    @Autowired
    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public Professor create(Professor professsor){
        return this.professorRepository.save(professsor);
    }

    public List<Professor> show(){
        return this.professorRepository.findAll();
    }

    public void update(UUID id, ProfessorDTO professorDTO) throws Exception {
        Professor professor = this.professorRepository.findById(id).orElseThrow( () -> new Exception());

        professor.setNome(professorDTO.getNome());
        professor.setGenero(professorDTO.getGenero());
        professor.setCurso(professorDTO.getCurso());
        professor.setEndereco(professorDTO.getEndereco());
        professor.setContato(professorDTO.getContato());

        this.professorRepository.save(professor);
    }

    public void delete(UUID id) throws Exception{
        Professor professor = this.professorRepository.findById(id).orElseThrow( () -> new Exception());

        this.professorRepository.delete(professor);
    }

    public Professor listByMatricula(String matricula) throws Exception {
        if(this.professorRepository.findByMatricula(matricula).isEmpty()) {
            throw new Exception("Professor não cadastrado");
        }

        return this.professorRepository.findByMatricula(matricula).get();
    }

    public Professor listByNome(String nome) throws Exception {
        if(this.professorRepository.findByNome(nome).isEmpty()) {
            throw new Exception("Professor não cadastrado");
        }

        return this.professorRepository.findByNome(nome).get();
    }
}
