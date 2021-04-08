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
public class Emprestimo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToOne(cascade = CascadeType.ALL)
    private Usuario usuario;

    private String dataEmprestimo;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Livro> livros;
    private boolean situacao;
}
