/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.Entities;

/**
 *
 * @author julia
 */
public class Aluguel {
    private int id;
    private int cliente_id;
    private int filme_id;
    private String data_entrega;
    private String status;
    private Float total;

    private String cliente_nome;
    private String filme_title;
    private float aluguel;

    public Aluguel() {}

    public Aluguel(int id, int cliente_id, int filme_id, String data_entrega, String status, Float total, String cliente_nome, String filme_title, float aluguel) {
        this.id = id;
        this.cliente_id = cliente_id;
        this.filme_id = filme_id;
        this.data_entrega = data_entrega;
        this.status = status;
        this.total = total;
        this.cliente_nome = cliente_nome;
        this.filme_title = filme_title;
        this.aluguel = aluguel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public int getFilme_id() {
        return filme_id;
    }

    public void setFilme_id(int filme_id) {
        this.filme_id = filme_id;
    }

    public String getData_entrega() {
        return data_entrega;
    }

    public void setData_entrega(String data_entrega) {
        this.data_entrega = data_entrega;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public String getCliente_nome() {
        return cliente_nome;
    }

    public void setCliente_nome(String cliente_nome) {
        this.cliente_nome = cliente_nome;
    }

    public String getFilme_title() {
        return filme_title;
    }

    public void setFilme_title(String filme_title) {
        this.filme_title = filme_title;
    }

    public float getAluguel() {
        return aluguel;
    }

    public void setAluguel(float aluguel) {
        this.aluguel = aluguel;
    }
}
