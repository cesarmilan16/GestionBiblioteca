package Modelo;

import java.util.ArrayList;

public class Usuario {
    private String nombre;
    private String apellido;
    private ArrayList<Libro> librosPrestados = new ArrayList<>();

    public Usuario(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }    
}