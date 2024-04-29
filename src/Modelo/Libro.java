package Modelo;

public class Libro {
    private String titulo;
    private String categoria;
    private Usuario usuario;
    private boolean disponible;

    public Libro(String titulo, String categoria, boolean disponible) {
        this.titulo = titulo;
        this.categoria = categoria;
        this.usuario = null;
    }

    
    public String getTitulo() {
        return titulo;
    }

    public String getCategoria() {
        return categoria;
    }
}