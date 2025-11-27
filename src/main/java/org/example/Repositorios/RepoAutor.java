package org.example.Repositorios;

import org.example.Entidades.Autores;
import org.example.Entidades.Libros;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class RepoAutor {

    private Session session;

    public RepoAutor(Session session) {
        this.session = session;
    }

    public void crearAutor(String dni, String nombre, String nacionalidad){
        Transaction transaction = this.session.beginTransaction();
        Autores autores = new Autores(dni,nombre,nacionalidad);
        session.persist(autores);
        transaction.commit();
    }

    public void eliminarAutor(String dni){
        /*
        Transaction transaction = this.session.beginTransaction();

        Query query = session.createQuery("select a from Autores a where a.dni= :dni").setParameter("dni",dni);

        List<Autores> autoresList = query.getResultList();

        for (Autores autores : autoresList){
            session.remove(autores);
        }

        transaction.commit();*/
        Transaction transaction = this.session.beginTransaction();
        //Comprobamos que existe el autor
        Autores autores = session.find(Autores.class,dni);
        if (autores == null){
            System.out.println("No existe autor con DNI -> " + dni);
            return;
        }
        //Eliminamos su tlf
        if (autores.getTelefonos() != null){
            session.remove(autores.getTelefonos());
        }
        //Eliminamos relación con los libros
        for (Libros libro : autores.getLibros()){
            libro.getAutores().remove(autores);
        }
        //Eliminamos autor
        session.remove(autores);

        transaction.commit();

        System.out.println("Autor eliminado");
    }

    public void buscarLibrosAutores(String dni){
        Transaction transaction = this.session.beginTransaction();

        Query query = session.createQuery("SELECT a.libros FROM Autores a WHERE a.dniAutor = :dni").setParameter("dni",dni);

        List<Libros> librosList = query.getResultList();

        if (librosList.isEmpty()){
            System.out.println("No hay libros para este autor");
        }

        for (Libros libros : librosList){
            System.out.println(libros);
        }

    }

    public void mostrarAutoresLibros(){
        Query query = session.createQuery("select a, l from Autores a join a.libros l");

        List<Object[]> lista = query.getResultList();

        for (Object[] resultado: lista){
            Autores autores = (Autores) resultado [0];
            Libros libros = (Libros) resultado[1];

            System.out.println("Autor[" + autores.getNombre() +"] DNI["+autores.getDniAutor()+"] Teléfono["+autores.getTelefonos()+"] Libro ["+libros.getTitulo()+"] Precio["+libros.getPrecio()+"]");

        }

    }


}
