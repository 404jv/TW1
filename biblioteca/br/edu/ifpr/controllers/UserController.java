package br.edu.ifpr.controllers;

import javax.swing.JOptionPane;

import br.edu.ifpr.repositories.UserRepository;

public class UserController {
  UserRepository userRepository;

  public UserController() {
    this.userRepository = UserRepository.getInstance();
  }

  public void create() {
    String nome = JOptionPane.showInputDialog("Digite o nome");

    String email = JOptionPane.showInputDialog("Digite o email, do(a) " + nome);

    String senha = JOptionPane.showInputDialog("Digite uma senha para o(a) " + nome);

    String idade = JOptionPane.showInputDialog("Qual é a idade do(a) " + nome + "?");

    String curso = JOptionPane.showInputDialog("E o curso dele(a)?");

    this.userRepository.create(nome, email, senha, idade, curso);
  }
}
