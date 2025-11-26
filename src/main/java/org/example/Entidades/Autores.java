package org.example.Entidades;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Autores {
    @Id
    private String dniAutor;
    private String nombre;
    private String nacionalidad;

    @ManyToMany(mappedBy = "autores")
    private List<Libros> libros = new ArrayList<>();

    @OneToOne(mappedBy = "autor",cascade = CascadeType.ALL)
    private Telefonos telefonos;

    public Autores() {
    }

    public Autores(String dniAutor, String nombre, String nacionalidad) {
        this.dniAutor = dniAutor;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    public String getDniAutor() {
        return dniAutor;
    }

    public void setDniAutor(String dniAutor) {
        this.dniAutor = dniAutor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public List<Libros> getLibros() {
        return libros;
    }

    public void setLibros(List<Libros> libros) {
        this.libros = libros;
    }

    public Telefonos getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(Telefonos telefonos) {
        this.telefonos = telefonos;
    }
}
