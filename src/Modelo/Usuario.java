package Modelo;

import java.util.ArrayList;

public class Usuario {
    private int codigo;

    private String nombre;
    private String apellido;
    private ArrayList<Libro> librosPrestados;

    public Usuario(int codigo, String nombre, String apellido) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        librosPrestados = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getCodigo() {
        return codigo;
    }

    public void prestar(Libro libro) {
        libro.prestarA(this);
        librosPrestados.add(libro);
    }

    public void devolver(Libro libro) {
        libro.devolverA(this);
        librosPrestados.remove(libro);
    }

    public boolean tieneLibrosPrestados() {
        return librosPrestados.size() > 0;
    }

    public void listarLibrosEnPrestamo() {
        if (tieneLibrosPrestados()){
            librosPrestados.sort((a, b) -> a.getFechaPrestamo().compareTo(b.getFechaPrestamo()));
            librosPrestados.forEach(libro->libro.escribirDatos());
        }
        else{
            System.out.println("El usuario " + this.nombre + " no tiene libros prestados.");
        }
    }
}