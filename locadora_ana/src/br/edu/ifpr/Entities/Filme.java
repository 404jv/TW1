package br.edu.ifpr.Entities;

/**
 *
 * @author ana
 */
public class Filme {
    private int id;
    private String titulo;
    private float aluguel;

    public Filme() {}

    public Filme(int id, String titulo, float aluguel) {
        this.id = id;
        this.titulo = titulo;
        this.aluguel = aluguel;
    }

    public Filme(String titulo, float aluguel) {
        this.titulo = titulo;
        this.aluguel = aluguel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public float getAluguel() {
        return aluguel;
    }

    public void setAluguel(float aluguel) {
        this.aluguel = aluguel;
    }
}
