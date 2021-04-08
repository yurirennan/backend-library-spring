package br.edu.fafic.backendlibrary.dto;

import br.edu.fafic.backendlibrary.domain.Contato;
import br.edu.fafic.backendlibrary.domain.Curso;
import br.edu.fafic.backendlibrary.domain.Endereco;
import br.edu.fafic.backendlibrary.enums.Sexo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AlunoDTO {
    private String nome;
    private Sexo genero;
    private Integer periodoCurso;
    private Curso curso;
    private Endereco endereco;
    private Contato contato;
}
