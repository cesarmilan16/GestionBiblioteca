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

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

}
