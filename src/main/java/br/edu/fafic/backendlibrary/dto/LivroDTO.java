package br.edu.fafic.backendlibrary.dto;

import br.edu.fafic.backendlibrary.enums.Area;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LivroDTO {
    private String nome;
    private Area area;
}
