/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.Models;

import br.edu.ifpr.DAOs.ClientesDAO;
import br.edu.ifpr.Entities.Cliente;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ana
 */
public class ClienteModel {
    public void create(Cliente cliente) {
        ClientesDAO clientesDAO = new ClientesDAO();

        try {
            Cliente clienteJaExiste = clientesDAO.procurarPorCpf(cliente.getCpf());

            if (clienteJaExiste != null) {
                JOptionPane.showMessageDialog(
                    null,
                    "Usuário já existe com esse cpf!",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            clientesDAO.criar(cliente);
        } catch (SQLException e) {
            Logger.getLogger(ClienteModel.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
