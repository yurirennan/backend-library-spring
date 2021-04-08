package br.edu.fafic.backendlibrary.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Biblioteca implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String nome;
    private String nomeInstituicao;

    @OneToOne(cascade = CascadeType.ALL)
    private Bibliotecario bibliotecario;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Livro> livros;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Usuario> usuarios;

}
