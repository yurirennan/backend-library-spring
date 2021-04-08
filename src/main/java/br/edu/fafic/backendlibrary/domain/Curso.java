package br.edu.fafic.backendlibrary.domain;

import br.edu.fafic.backendlibrary.enums.Area;
import lombok.*;

import javax.persistence.Embeddable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
@Embeddable
public class Curso {
    private String nome;
    private Area area;
}
