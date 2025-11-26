package org.example;

import java.io.File;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory SESSION_FACTORY;

    static {
        try {
            String hibernatePropsFilePath = "./src/hibernate.cfg.xml"; // Ruta al fichero

            File hibernatePropsFile = new File(hibernatePropsFilePath);

            Configuration config = new Configuration().configure(hibernatePropsFile);

            //Registrar las entidades de las clases
            //config.addAnnotatedClass(org.example.Entidades.Departamento.class);
            //config.addAnnotatedClass(org.example.Entidades.Empleado.class);
            config.addAnnotatedClass(org.example.Entidades.Autores.class);
            config.addAnnotatedClass(org.example.Entidades.Libros.class);
            config.addAnnotatedClass(org.example.Entidades.Telefonos.class);


            SESSION_FACTORY = config.buildSessionFactory();

            //SESSION_FACTORY = new Configuration().configure(hibernatePropsFile).buildSessionFactory();

        }catch(Throwable ex) {
            System.err.println("Error al crear la configuración de hibernate" + ex.getMessage());
            throw new ExceptionInInitializerError();
        }
    }

    public static SessionFactory get() {
        return SESSION_FACTORY;
    }
}
