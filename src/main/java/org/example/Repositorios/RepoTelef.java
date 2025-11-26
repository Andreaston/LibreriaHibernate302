package org.example.Repositorios;

import org.example.Entidades.Autores;
import org.example.Entidades.Telefonos;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class RepoTelef {

    private Session session;

    public RepoTelef(Session session) {
        this.session = session;
    }

    public void vincularTelefonoAutor(String dni, String tlf){
        Transaction transaction = this.session.beginTransaction();
        Autores autor = session.find(Autores.class,dni);

        if (autor == null){
            System.out.println("El autor no existe");
            return;
        }

        if (autor.getTelefonos() != null){
            System.out.println("El autor ya tiene tlf");
            return;
        }


        Telefonos telefonos = new Telefonos(dni,tlf);
        telefonos.setAutor(autor);

        session.persist(telefonos);

        transaction.commit();
    }


}
