package br.edu.fafic.backendlibrary.domain;

import br.edu.fafic.backendlibrary.enums.Sexo;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo_usuario")
@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String nome;

    @Column(unique = true)
    private String cpf;

    private Integer genero;

    @Column(unique = true, length = 6)
    private String matriculaFaculdade;

    @Embedded
    private Endereco endereco;

    @Embedded
    private Contato contato;

    @Embedded
    private Login login;

    public Sexo getGenero() {
        return Sexo.fromCodigo(this.genero);
    }

    public void setGenero(Sexo genero) {
        this.genero = genero.getCodigo();
    }

    public Usuario(UUID id, String nome, String cpf, Sexo genero, String matriculaFaculdade, Endereco endereco, Contato contato, Login login) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.genero = genero.getCodigo();
        this.matriculaFaculdade = matriculaFaculdade;
        this.endereco = endereco;
        this.contato = contato;
        this.login = login;
    }
}
