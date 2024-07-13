/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author BUI TUAN DAT
 */
public class Account {
    private int aid;
    private String name;
    private double amount;
    private String username;
    private String password;
    private int role;

    public Account() {
    }
     public Account(String name, double amount, String username, String password, int role) {
        this.name = name;
        this.amount = amount;
        this.username = username;
        this.password = password;
        this.role = role;
    }
    
    public Account(int aid, String name, double amount, String username, String password, int role) {
        this.aid = aid;
        this.name = name;
        this.amount = amount;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

   
    
    
    
}
