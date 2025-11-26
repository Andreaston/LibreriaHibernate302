package org.example.Repositorios;

import org.example.Entidades.Autores;
import org.example.Entidades.Libros;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.InputMismatchException;
import java.util.Queue;

public class RepoLibro {

    private Session session;

    public RepoLibro(Session session) {
        this.session = session;
    }

    public void nuevoLibro(String titulo, double precio){
        try {
            Transaction transaction = this.session.beginTransaction();
            Libros libros = new Libros(titulo,precio);
            session.persist(libros);
            transaction.commit();
        } catch (InputMismatchException e){
            System.out.println("Escribe los decimales con coma \",\" no con punto \".\"");
        }

    }


    public void ligarAutorLibro(int id, String dni){
        Transaction transaction = this.session.beginTransaction();
        Libros libro = session.find(Libros.class, id);
        Autores autor = session.find(Autores.class, dni);

        if (libro == null || autor == null){
            System.out.println("No se encuentra la información que ofrece");
            return;
        }

        libro.getAutores().add(autor);
        autor.getLibros().add(libro);

        session.merge(libro);
        session.merge(autor);

        transaction.commit();
        System.out.println("Se ha creado la relación");
    }


}
