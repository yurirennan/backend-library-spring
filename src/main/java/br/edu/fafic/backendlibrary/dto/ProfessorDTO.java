package br.edu.fafic.backendlibrary.dto;

import br.edu.fafic.backendlibrary.domain.Contato;
import br.edu.fafic.backendlibrary.domain.Curso;
import br.edu.fafic.backendlibrary.domain.Endereco;
import br.edu.fafic.backendlibrary.enums.Sexo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ProfessorDTO {
    private String nome;
    private Sexo genero;
    private Curso curso;
    private Endereco endereco;
    private Contato contato;
}
