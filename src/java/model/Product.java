/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author BUI TUAN DAT
 */
public class Product {

    private int id;
    private String name;
    private double price;
    private int quantity;
    private String describe, image;
    private Date dom;
    private Category cid;
    private Publisher pid;
    private Author auid;

    public Product() {
    }

    public Product(int id, String name, double price, int quantity, String describe, String image, Date dom, Category cid, Publisher pid, Author auid) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.describe = describe;
        this.image = image;
        this.dom = dom;
        this.cid = cid;
        this.pid = pid;
        this.auid = auid;
    }
    public Product(String name, double price, int quantity, String describe, String image, Date dom, Category cid, Publisher pid, Author auid) {
        
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.describe = describe;
        this.image = image;
        this.dom = dom;
        this.cid = cid;
        this.pid = pid;
        this.auid = auid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getDom() {
        return dom;
    }

    public void setDom(Date dom) {
        this.dom = dom;
    }

    public Category getCid() {
        return cid;
    }

    public void setCid(Category cid) {
        this.cid = cid;
    }

    public Publisher getPid() {
        return pid;
    }

    public void setPid(Publisher pid) {
        this.pid = pid;
    }

    public Author getAuid() {
        return auid;
    }

    public void setAuid(Author auid) {
        this.auid = auid;
    }

    

   
}
