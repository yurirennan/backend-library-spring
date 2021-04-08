package br.edu.fafic.backendlibrary.domain;

import lombok.*;

import javax.persistence.Embeddable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
@Embeddable
public class Contato {
    private String email;
    private String telefone;
}
