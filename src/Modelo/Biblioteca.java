package Modelo;

import java.util.ArrayList;
import java.util.Scanner;

import Herramientas.Utilidades;

public class Biblioteca {
    private ArrayList<Libro> libros = new ArrayList<>();
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public Usuario buscarUsuario(int codigo) {
        Usuario usuarioEncontrado = null;
        int contador = 0;
        while (usuarioEncontrado == null && contador < usuarios.size()) {
            if (usuarios.get(contador).getCodigo() == codigo) {
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
        System.out.println("Introduce codigo: ");
        int codigo = Utilidades.leerEntero("código usuario");

        Usuario usuarioEncontrado = buscarUsuario(codigo);

        if (usuarioEncontrado == null) {
            System.out.println("Introduce nombre: ");
            String nombre = scanner.nextLine();
            System.out.println("Introduce apellido: ");
            String apellido = scanner.nextLine();
            Usuario usuario = new Usuario(codigo, nombre, apellido);
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
        System.out.println("Introduce codigo: ");
        int codigo = Utilidades.leerEntero("código usuario");
        
        Usuario usuarioEncontrado = buscarUsuario(codigo);

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

        Libro libroEncontrado = buscarLibro(titulo);

        if (libroEncontrado == null) {
            System.out.println("Categoria libro: ");
            String categoria = scanner.nextLine();
            Libro libro = new Libro(titulo, categoria, true);
            libros.add(libro);
            System.out.println("Libro agregado con exito.");       
        }
        else{
            System.out.println("Ese titulo ya existe.");
        }
    }

    public void bajaLibro() {
        System.out.println("***************************");
        System.out.println("******* Baja Libro *******");
        System.out.println("***************************");
        System.out.println("Nombre libro: ");
        String titulo = scanner.nextLine();

        Libro libroEncontrado = buscarLibro(titulo);

        // TODO: Hay que incorporar que no se puede bajar si esta prestado
        if (libroEncontrado != null) {
            libros.remove(libroEncontrado);
            System.out.println("Libro borrado con exito.");     
        }
        else{
            System.out.println("Libro no existente.");
        }
    }

    public void gestionPrestamoLibro() {
        boolean salir = false;
        while (!salir) {
            salir = mostrarMenuGestionPermisos();
        }
    }

    private boolean mostrarMenuGestionPermisos() {
        boolean salir = false;
        System.out.println("************************************");
        System.out.println("****** Menu gestión prestamos ******");
        System.out.println("************************************");
        System.out.println("1.- Prestar libro");
        System.out.println("2.- Devolver libro");

        System.out.println("9.- Salir");

        
        String opcion = Utilidades.leerString("Opción: ");

        switch (opcion) {
            case "1":
                prestarLibro();
                break;
            case "2":
                devolverLibro();
                break;
            case "9":
                salir = true;
                break;
            default:
                break;
        }
        return salir;
    }

    private void prestarLibro() {
        int codigoUsuario = Utilidades.leerEntero("código usuario: ");
        Usuario usuario = buscarUsuario(codigoUsuario);

        if (usuario != null) {
            String titulo = Utilidades.leerString("titulo del libro");
            Libro libro = buscarLibro(titulo);
            if (libro != null) {
                usuario.prestar(libro);
            }
            else {
                System.out.println("El libro no se ha encontrado.");
            }
        }
        else {
            System.out.println("El usuario no se ha encontrado.");
        }
    }

    private void devolverLibro() {
        String titulo = Utilidades.leerString("titulo del libro: ");
        Libro libro = buscarLibro(titulo);

        if (libro != null) {
            int codigo = Utilidades.leerEntero("código usuario: ");
            Usuario usuario = buscarUsuario(codigo);
            if (usuario != null) {
                usuario.devolver(libro); 
            }
            else {
                System.out.println("El usuario no se ha encontrado.");
            }
        }
        else {
            System.out.println("El libro no se ha encontrado.");
        }
    }

    private ArrayList<String> listarCategorias(ArrayList<Libro> libros){
        ArrayList<String> categorias = new ArrayList<>();

        for (Libro it: libros) {
            if (!categorias.contains(it.getCategoria())){
                categorias.add(it.getCategoria());
            }
        }
        return categorias;
    }

    private ArrayList<Libro> darLibrosDisponibles() {
        ArrayList<Libro> librosDisponibles = new ArrayList<>();

        for (Libro it : libros) {
            if (it.getUsuario() == null) {
                librosDisponibles.add(it);
            }
        }
        return librosDisponibles;
    }

    public void listarLibrosDisponibles() {
        ArrayList<Libro> librosDisponibles = darLibrosDisponibles();
        ArrayList<String> categoriasLibrosDisponibles = listarCategorias(librosDisponibles);
        
        for (String categoria : categoriasLibrosDisponibles) {
            System.out.println("Categoria listada: " + categoria);
            for (Libro libro : librosDisponibles) {
                if (libro.getCategoria().equals(categoria)){
                    libro.escribirDatos();
                }
            }
       }
    }

    public void listarLibrosPrestados() {
        int codigoUsuario = Utilidades.leerEntero("codigo usuario");
        Usuario usuario = buscarUsuario(codigoUsuario);
        if (usuario == null){
            System.out.println("Código de usuario inexistente.");
        }
        else{
            usuario.listarLibrosEnPrestamo();
        }
    }

}