package br.edu.fafic.backendlibrary.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

@JsonFormat(shape = JsonFormat.Shape.NUMBER)
public enum Sexo {

    MASCULINO(1, "MASCULINO"),
    FEMININO(2, "FEMININO");

    private Integer codigo;
    private String sexo;

    Sexo(int codigo, String sexo) {
        this.codigo = codigo;
        this.sexo = sexo;
    }

    @JsonValue
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @JsonCreator
    public static Sexo fromCodigo(Integer codigo) {
        return Arrays.stream(Sexo.values()).filter(sexo -> sexo.getCodigo().equals(codigo))
                .findFirst().orElse(null);
    }
}
