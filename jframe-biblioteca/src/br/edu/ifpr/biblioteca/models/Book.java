package br.edu.ifpr.biblioteca.models;

public class Book {
    private int id;
    private String titulo;
    private String autor;
    private String editora;
    private int paginas;
    private int anoPubli;
    private String genero;

    public Book(String titulo, String autor, String editora, int paginas, int anoPubli, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.paginas = paginas;
        this.anoPubli = anoPubli;
        this.genero = genero;
    }

   public Book() {}
 
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
  
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditora() {
        return editora;
    }

    public int getPaginas() {
        return paginas;
    }

    public int getAnoPubli() {
        return anoPubli;
    }

    public String getGenero() {
        return genero;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public void setAnoPubli(int anoPubli) {
        this.anoPubli = anoPubli;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
