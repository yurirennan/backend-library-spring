package br.edu.fafic.backendlibrary.domain;

import br.edu.fafic.backendlibrary.enums.Area;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Livro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    private String nome;

    @Column(unique = true)
    private String isbn;

    private Integer area;

    public Area getArea() {
        return Area.fromCodigo(this.area);
    }

    public void setArea(Area area) {
        this.area = area.getCodigo();
    }

    public Livro(UUID id, String nome, String isbn, Area area) {
        this.id = id;
        this.nome = nome;
        this.isbn = isbn;
        this.area = area.getCodigo();
    }
}
