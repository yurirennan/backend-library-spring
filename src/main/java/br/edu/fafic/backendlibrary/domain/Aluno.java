package br.edu.fafic.backendlibrary.domain;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Aluno(a)")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Aluno extends Usuario{
    @Embedded
    private Curso curso;
    private Integer periodoCurso;

}
