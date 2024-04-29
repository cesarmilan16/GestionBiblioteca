package Modelo;

public class Libro {
    private String titulo;
    private String categoria;
    private boolean disponible;

    public Libro(String titulo, String categoria, boolean disponible) {
        this.titulo = titulo;
        this.categoria = categoria;
        this.disponible = true;
    }

    
    public String getTitulo() {
        return titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}