package br.edu.fafic.backendlibrary.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
@Embeddable
public class Login {
    @Column(unique = true)
    private String matriculaLogin;
    private String senhaLogin;
}
