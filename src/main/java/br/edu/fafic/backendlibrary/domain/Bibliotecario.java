package br.edu.fafic.backendlibrary.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Bibliotecario(a)")
public class Bibliotecario extends Usuario {
}
