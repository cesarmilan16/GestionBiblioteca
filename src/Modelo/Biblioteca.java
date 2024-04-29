package Modelo;

import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    private ArrayList<Libro> libros = new ArrayList<>();
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public Usuario buscarUsuario(String nombre) {
        Usuario usuarioEncontrado = null;
        int contador = 0;
        while (usuarioEncontrado == null && contador < usuarios.size()) {
            if (usuarios.get(contador).getNombre().equals(nombre)) {
                usuarioEncontrado = usuarios.get(contador);
            }
            contador ++;
        }
        return usuarioEncontrado;
    }

    public Libro buscarLibro(String titulo) {
        Libro libroEncontrado = null;
        int contandor = 0;
        while (libroEncontrado == null && contandor < libros.size()) {
            if (libros.get(contandor).getTitulo().equals(titulo)) {
                libroEncontrado = libros.get(contandor);
            }
            contandor ++;
        }
        return libroEncontrado;
    }

    public void altaUsuario() {
        System.out.println("***************************");
        System.out.println("****** Alta Usuario *******");
        System.out.println("***************************");
        System.out.println("Introduce nombre: ");
        String nombre = scanner.nextLine();
        System.out.println("Introduce apellido: ");
        String apellido = scanner.nextLine();

        Usuario usuarioEncontrado = buscarUsuario(nombre);

        if (usuarioEncontrado == null) {
            Usuario usuario = new Usuario(nombre, apellido);
            usuarios.add(usuario);
            System.out.println("Usuario añadido con exito");
        }
        else {
            System.out.println("Usuario ya existente");
        }
    }
    
    public void bajaUsuario() {
        System.out.println("***************************");
        System.out.println("****** Baja Usuario *******");
        System.out.println("***************************");
        System.out.println("Introduce nombre: ");
        String nombre = scanner.nextLine();
        
        Usuario usuarioEncontrado = buscarUsuario(nombre);

        if (usuarioEncontrado != null) {
            usuarios.remove(usuarioEncontrado);
            System.out.println("Se ha eliminado al usuario: " + usuarioEncontrado.getNombre());
        }
        else {
            System.out.println("Usuario no existente");
        }
    }

    public void altaLibro() {
        System.out.println("***************************");
        System.out.println("******* Alta Libro *******");
        System.out.println("***************************");
        System.out.println("Nombre libro: ");
        String titulo = scanner.nextLine();
        System.out.println("Categoria libro: ");
        String categoria = scanner.nextLine();

        Libro libroEncontrado = buscarLibro(titulo);

        if (libroEncontrado == null) {
            Libro libro = new Libro(titulo, categoria, true);
            libros.add(libro);
            System.out.println("Libro agregado con exito.");       
        }
        else{
            System.out.println("Libro ya existente.");
        }
    }

    public void bajaLibro() {
        System.out.println("***************************");
        System.out.println("******* Baja Libro *******");
        System.out.println("***************************");
        System.out.println("Nombre libro: ");
        String titulo = scanner.nextLine();

        Libro libroEncontrado = buscarLibro(titulo);

        if (libroEncontrado == null) {
            libros.remove(libroEncontrado);
            System.out.println("Libro borrado con exito.");     
        }
        else{
            System.out.println("Libro no existente.");
        }
    }
}
