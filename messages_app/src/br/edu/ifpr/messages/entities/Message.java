/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpr.messages.entities;

/**
 *
 * @author joao
 */
public class Message {
    private int id;
    private String corpo;
    private int id_remetente;
    private int id_destinatario;
    
    public Message(int id, String corpo, int id_remetente, int id_destinatario) {
        this.id = id;
        this.corpo = corpo;
        this.id_remetente = id_remetente;
        this.id_destinatario = id_destinatario;
    }
    
    public Message(String corpo, int id_remetente, int id_destinatario) {
        this.corpo = corpo;
        this.id_remetente = id_remetente;
        this.id_destinatario = id_destinatario;
    }
    
    public Message() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }

    public int getId_remetente() {
        return id_remetente;
    }

    public void setId_remetente(int id_remetente) {
        this.id_remetente = id_remetente;
    }

    public int getId_destinatario() {
        return id_destinatario;
    }

    public void setId_destinatario(int id_destinatario) {
        this.id_destinatario = id_destinatario;
    }
}
