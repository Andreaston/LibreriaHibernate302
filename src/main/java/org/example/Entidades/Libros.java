package org.example.Entidades;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Libros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLibro;
    private String titulo;
    private double precio;

    public Libros() {
    }

    public Libros(int idLibro, String titulo, double precio) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.precio = precio;
    }

    @ManyToMany
    //Aqui vamos a definir la tabla intermedia
    @JoinTable(
            name = "Libros_Autores", //Tabla intermedia
            joinColumns = @JoinColumn(name = "idLibro"), //unimos esta clase...
            inverseJoinColumns = @JoinColumn(name = "dniAutor") //...con esta otra
    )
    //El nombre de este valor lo usaremos para mapear en la otra clase
    private List<Autores> autores = new ArrayList<>();

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public List<Autores> getAutores() {
        return autores;
    }

    public void setAutores(List<Autores> autores) {
        this.autores = autores;
    }
}
