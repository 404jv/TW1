/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.Models;

import br.edu.ifpr.DAOs.AlugueisDAO;
import br.edu.ifpr.DAOs.ClientesDAO;
import br.edu.ifpr.DAOs.FilmesDAO;
import br.edu.ifpr.Entities.Aluguel;
import br.edu.ifpr.Entities.Filme;
import br.edu.ifpr.Entities.Cliente;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ana
 */
public class AluguelModel extends AbstractTableModel {
    ArrayList<Aluguel> alugueis = new ArrayList();
    String[] colunas = { "ID", "Cliente", "Filme", "Status", "Data da entrega", "Total" };

    public AluguelModel() {
        AlugueisDAO alugueisDAO = new AlugueisDAO();

        try {
            this.alugueis = alugueisDAO.listar();
        } catch (SQLException e) {
            Logger.getLogger(AluguelModel.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void criar(String filmeTitulo, String cpf) {
        AlugueisDAO alugueisDAO = new AlugueisDAO();
        FilmesDAO filmeDAO = new FilmesDAO();
        ClientesDAO clientesDAO = new ClientesDAO();

        try {
            Filme filme = filmeDAO.procurarPorTitulo(filmeTitulo);

            if (filme == null) {
                JOptionPane.showMessageDialog(
                    null,
                    "Esse filme não foi registrado!",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
                );
               return;
            }

            Cliente cliente = clientesDAO.procurarPorCpf(cpf);

            if (cliente == null) {
                JOptionPane.showMessageDialog(
                    null,
                    "Cliente não encontrado!",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
                );
               return;
            }

            Aluguel aluguel = new Aluguel(cliente.getId(), filme.getId());

            alugueisDAO.criar(aluguel);

            JOptionPane.showMessageDialog(
                null,
                "Aluguel criado com sucesso!",
                "Sucesso",
                JOptionPane.INFORMATION_MESSAGE
            );
        } catch (SQLException e) {
            Logger.getLogger(AluguelModel.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void devoluca(String aluguelId, String dataEntrega) {
        AlugueisDAO alugueisDAO = new AlugueisDAO();

        try {
            Aluguel aluguel = alugueisDAO.procurarPorId(aluguelId);

            if (aluguel == null) {
                JOptionPane.showMessageDialog(
                    null,
                    "Aluguel não encontrado!",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
                );
               return;
            }

            if (aluguel.getStatus().equals("entregue")) {
                JOptionPane.showMessageDialog(
                    null,
                    "Esse filme já foi entregue!",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
                );
               return;
            }

            aluguel.setData_entrega(dataEntrega);
            aluguel.setStatus("entregue");
            aluguel.setTotal(aluguel.getAluguel());

            alugueisDAO.atualizar(aluguel);

            JOptionPane.showMessageDialog(
                null,
                "Filme devolvido com sucesso!",
                "Sucesso",
                JOptionPane.INFORMATION_MESSAGE
            );
        } catch (SQLException e) {
            Logger.getLogger(AluguelModel.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    @Override
    public int getRowCount() {
        if (this.alugueis == null) return 0;
        return this.alugueis.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    
    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return this.alugueis.get(rowIndex).getId();
            case 1:
                return this.alugueis.get(rowIndex).getCliente_nome();
            case 2:
                return this.alugueis.get(rowIndex).getFilme_title();
            case 3:
                return this.alugueis.get(rowIndex).getStatus();
            case 4:
                return this.alugueis.get(rowIndex).getData_entrega();
            case 5:
                return this.alugueis.get(rowIndex).getTotal();
        }
        return null;
    }
}
