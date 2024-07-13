/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author BUI TUAN DAT
 */
public class OrderLine {
    private int oid,pid,quantity;//quantity so luong da mua
    private double price;//gia ban
    private String pName;

    public OrderLine() {
    }

    public OrderLine(int oid, int pid, int quantity, double price, String pName) {
        this.oid = oid;
        this.pid = pid;
        this.quantity = quantity;
        this.price = price;
        this.pName = pName;
    }

    public OrderLine(int oid, int pid, int quantity, double price) {
        this.oid = oid;
        this.pid = pid;
        this.quantity = quantity;
        this.price = price;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }
    
}
