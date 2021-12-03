package br.edu.ifpr.biblioteca.models;

public class User {
    private int id;
    private String nome;
    private int idade;
    private String email;
    private String senha;
    private String curso;

    public User(String nome, int idade, String email, String senha, String curso) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.senha = senha;
        this.curso = curso;
    }
    
    public User() {}

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
   }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getCurso() {
        return curso;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
