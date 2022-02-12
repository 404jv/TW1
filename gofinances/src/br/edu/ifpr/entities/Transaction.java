/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.entities;

import java.util.Date;

/**
 *
 * @author joao
 */
public class Transaction {
    private int id;
    private String title;
    private float price;
    private Date date;
    private String type;
    private int category_id;
    private int user_id;

    private String category_name;

    public Transaction() {}

    public Transaction(String title, float price, Date date, String type, String category_name, int user_id) {
        this.title = title;
        this.price = price;
        this.date = date;
        this.type = type;
        this.category_name = category_name;
        this.user_id = user_id;
    }

    public Transaction(int id, String title, float price, Date date, String type, int category_id, int user_id) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.date = date;
        this.type = type;
        this.category_id = category_id;
        this.user_id = user_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

}
