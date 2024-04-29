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
        }
        else {
            System.out.println("Usuario ya existente");
        }
    }
    
}
