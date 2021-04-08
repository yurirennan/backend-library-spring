package br.edu.fafic.backendlibrary.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum Area {
    HUMANAS(1, "HUMANAS"),
    EXATAS(2, "EXATAS");

    private Integer codigo;
    private String area;

    Area(Integer codigo, String area) {
        this.codigo = codigo;
        this.area = area;
    }

    @JsonValue
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @JsonCreator
    public static Area fromCodigo(Integer codigo) {
        return Arrays.stream(Area.values()).filter(area -> area.getCodigo().equals(codigo))
                .findFirst().orElse(null);
    }
}
