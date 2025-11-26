package org.example;

import org.example.Entidades.Autores;
import org.example.Entidades.Libros;
import org.example.Entidades.Telefonos;
import org.example.Repositorios.RepoAutor;
import org.example.Repositorios.RepoLibro;
import org.example.Repositorios.RepoTelef;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App{
    public static void main( String[] args ){

        Session session = HibernateUtil.get().openSession();
        //Transaction transaction = session.beginTransaction();

        RepoAutor repoAutor = new RepoAutor(session);
        RepoLibro repoLibro = new RepoLibro(session);
        RepoTelef repoTelef = new RepoTelef(session);
        /*
        Autores autor1 = new Autores("11111111A", "J.R.R. Tolkien", "Británica");
        Autores autor2 = new Autores("22222222B", "Gabriel García Márquez", "Colombiana");
        Autores autor3 = new Autores("33333333C", "George Orwell", "Británica");
        Autores autor4 = new Autores("44444444D", "Miguel de Cervantes", "Española");
        Autores autor5 = new Autores("55555555E", "J.K. Rowling", "Británica");

        Telefonos tel1 = new Telefonos("11111111A", "654123789");
        tel1.setAutor(autor1);

        Telefonos tel2 = new Telefonos("22222222B", "600987654");
        tel2.setAutor(autor2);

        Telefonos tel3 = new Telefonos("33333333C", "645222345");
        tel3.setAutor(autor3);

        Telefonos tel4 = new Telefonos("44444444D", "655111222");
        tel4.setAutor(autor4);

        Telefonos tel5 = new Telefonos("55555555E", "611555777");
        tel5.setAutor(autor5);

        Libros libro1 = new Libros(0, "El Señor de los Anillos", 39.95);
        libro1.getAutores().add(autor1);
        autor1.getLibros().add(libro1);

        Libros libro2 = new Libros(0, "Cien Años de Soledad", 24.50);
        libro2.getAutores().add(autor2);
        autor2.getLibros().add(libro2);

        Libros libro3 = new Libros(0, "1984", 19.90);
        libro3.getAutores().add(autor3);
        autor3.getLibros().add(libro3);

        Libros libro4 = new Libros(0, "El Quijote", 29.99);
        libro4.getAutores().add(autor4);
        autor4.getLibros().add(libro4);

        Libros libro5 = new Libros(0, "Harry Potter y la Piedra Filosofal", 22.50);
        libro5.getAutores().add(autor5);
        autor5.getLibros().add(libro5);

        session.persist(autor1);
        session.persist(tel1);
        session.persist(libro1);

        session.persist(autor2);
        session.persist(tel2);
        session.persist(libro2);

        session.persist(autor3);
        session.persist(tel3);
        session.persist(libro3);

        session.persist(autor4);
        session.persist(tel4);
        session.persist(libro4);

        session.persist(autor5);
        session.persist(tel5);
        session.persist(libro5);

        transaction.commit();
        */

        Scanner leer = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("1.Crear autor");
            System.out.println("2.Crear libro");
            System.out.println("3.Enlazar autor y libro");
            System.out.println("4.Insertar teléfono a autor");
            System.out.println("5.");
            System.out.println("6.");
            System.out.println("7.");
            System.out.println("8.");
            System.out.println("9.");
            System.out.println("10.");
            System.out.println("11. SALIR");
            System.out.println("OPCION:");

            opcion = leer.nextInt();

            switch (opcion){
                case 1:
                    leer.nextLine();
                    System.out.println("Dime el DNI del nuevo autor");
                    String dni = leer.nextLine();
                    System.out.println("Dime el NOMBRE del nuevo autor");
                    String nombre = leer.nextLine();
                    System.out.println("Dime la NACIONALIDAD del nuevo autor");
                    String nacionalidad = leer.nextLine();
                    repoAutor.crearAutor(dni,nombre,nacionalidad);
                    break;
                case 2:
                    try{
                        leer.nextLine();
                        System.out.println("Dime el título del nuevo libro");
                        String titulo = leer.nextLine();
                        System.out.println("Dime el precio de " + titulo);
                        double precio = leer.nextDouble();
                        repoLibro.nuevoLibro(titulo,precio);
                    } catch (InputMismatchException e){
                        System.out.println("Escribe los decimales con coma \",\" no con punto \".\"");
                        leer.nextLine();
                    }

                    break;
                case 3:
                    leer.nextLine();
                    System.out.println("Dime el ID del libro");
                    int idL = leer.nextInt();
                    leer.nextLine();
                    System.out.println("Dime el DNI del autor");
                    String idA = leer.nextLine();

                    repoLibro.ligarAutorLibro(idL,idA);

                    break;
                case 4:
                    leer.nextLine();
                    System.out.println("Dime el DNI del autor");
                    String dniT = leer.nextLine();
                    System.out.println("Dime el nº de teléfono");
                    String tlf = leer.nextLine();

                    repoTelef.vincularTelefonoAutor(dniT,tlf);

                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    System.out.println("Con Deus!!");
                    break;
                default:
                    System.out.println("No entendí");
                    break;
            }

        }while (opcion != 11);

        session.clear();

    }
}
