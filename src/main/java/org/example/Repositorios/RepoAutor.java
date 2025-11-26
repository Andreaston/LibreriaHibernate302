package org.example.Repositorios;

import org.example.Entidades.Autores;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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


}
