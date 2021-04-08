package br.edu.fafic.backendlibrary.service;

import br.edu.fafic.backendlibrary.domain.Emprestimo;
import br.edu.fafic.backendlibrary.domain.Livro;
import br.edu.fafic.backendlibrary.domain.Usuario;
import br.edu.fafic.backendlibrary.repository.EmprestimoRepository;
import br.edu.fafic.backendlibrary.repository.LivroRepository;
import br.edu.fafic.backendlibrary.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmprestimoService {
    private final EmprestimoRepository emprestimoRepository;
    private final UsuarioRepository usuarioRepository;
    private final LivroRepository livroRepository;

    @Autowired
    public EmprestimoService(EmprestimoRepository emprestimoRepository, UsuarioRepository usuarioRepository,
                             LivroRepository livroRepository) {
        this.emprestimoRepository = emprestimoRepository;
        this.usuarioRepository = usuarioRepository;
        this.livroRepository = livroRepository;
    }

    public Emprestimo create(Emprestimo emprestimo) throws Exception {
        Optional<Usuario> usuario;

        usuario = usuarioRepository.findByCpf(emprestimo.getUsuario().getCpf());

        if (usuario.isEmpty()) {
            throw new Exception("Usuário não cadastrado");
        }

        if(emprestimoUserIsBibliotecario(usuario.get())) {
           throw new Exception("Usario é um bibliotecario e não pode fazer emprestimo!");
        }

        if(!userAbleToMakeEmprestimo(usuario.get().getId())) {
            throw new Exception("Usuário com emprestimos atrasados");
        }

        if (emprestimo.getLivros().size() <= 0 || emprestimo.getLivros().size() > 3) {
            throw new Exception("O usuário só pode fazer um emprestimo de no máximo 3 livros");
        }

        if (searchEquals(emprestimo.getLivros()) >= 2) {
            throw new Exception("Livros repetidos");
        }

        List<Livro> livros = new ArrayList<>();

        for (int i = 0; i < emprestimo.getLivros().size(); i++) {
            try {
                if (livroRepository.findByIsbn(emprestimo.getLivros().get(i).getIsbn()).equals(null)) {
                    throw new Exception("Livros não encontrados");
                } else {
                    livros.add(livroRepository.findByIsbn(emprestimo.getLivros().get(i).getIsbn()));
                }
            } catch (Exception err) {
                throw new Exception("Livros não encontrados");
            }
        }

        emprestimo.setUsuario(usuario.get());
        emprestimo.setLivros(livros);
        emprestimo.setSituacao(false);
        return this.emprestimoRepository.save(emprestimo);
    }

    public List<Emprestimo> show() {
        return this.emprestimoRepository.findAll();
    }

    public void delete(Emprestimo emprestimo) throws Exception{
        this.emprestimoRepository.delete(emprestimo);
    }

    private int searchEquals(List<Livro> livros) {
        int count = 0;
        for (int i = 0; i < livros.size(); i++) {
            for (int j = 0; j < livros.size(); j++) {
                if (livros.get(i).getIsbn().equals(livros.get(j).getIsbn())) {
                    count++;
                }
            }

            if(count >= 2) {
                return count;
            } else {
                count = 0;
            }
        }

        return count;
    }

    private boolean userAbleToMakeEmprestimo(UUID id) {
        List<Optional<Emprestimo>> emprestimos = this.emprestimoRepository.findAllByUsuarioId(id);

        if (emprestimos.isEmpty()) {
            return true;
        }

        for (int i = 0; i < emprestimos.size(); i++) {
            if(emprestimos.get(i).get().isSituacao() == false) {
                return false;
            }
        }

        return true;
    }

    private boolean emprestimoUserIsBibliotecario(Usuario usuario){
        if (this.usuarioRepository.findTypeOfUser(usuario.getId()).equalsIgnoreCase("Bibliotecario(a)")) {
            return true;
        }

        return false;
    }

}
