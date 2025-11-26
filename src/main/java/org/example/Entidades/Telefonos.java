package org.example.Entidades;

import jakarta.persistence.*;
@Entity
public class Telefonos {
    @Id
    private String dniAutor;
    private String numero;

    @OneToOne
    @JoinColumn(name = "dniAutor") //Foreing Key
    private Autores autor;

    public Telefonos() {
    }

    public Telefonos(String dniAutor, String numero) {
        this.dniAutor = dniAutor;
        this.numero = numero;
    }

    public String getDniAutor() {
        return dniAutor;
    }

    public void setDniAutor(String dniAutor) {
        this.dniAutor = dniAutor;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Autores getAutor() {
        return autor;
    }

    public void setAutor(Autores autor) {
        this.autor = autor;
    }
}

