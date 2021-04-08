package br.edu.fafic.backendlibrary.domain;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Professor(a)")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Professor extends Usuario{
    @Embedded
    private Curso curso;
}
