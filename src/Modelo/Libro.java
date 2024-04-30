package Modelo;

import java.util.Date;
import java.util.Calendar;

public class Libro {
    private String titulo;
    private String categoria;
    private Usuario usuario;
    private Date fechaPrestamo;

    public Libro(String titulo, String categoria, boolean disponible) {
        this.titulo = titulo;
        this.categoria = categoria;
        usuario = null;
        fechaPrestamo = null;

    }


    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void prestarA(Usuario usuario) {
        this.usuario = usuario;
        Calendar calendar = Calendar.getInstance();
        this.fechaPrestamo = calendar.getTime();
    }


    public void devolverA(Usuario usuario) {
        this.usuario = null;
        this.fechaPrestamo = null;
    }

    public void escribirDatos() {
        System.out.println("Titulo: " + this.titulo);
        System.out.println("Categoria: " + this.categoria);
    } 

}