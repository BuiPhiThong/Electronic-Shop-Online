/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author BUI TUAN DAT
 */
public class Author {
    private int auid;
    private String name,from;

    public Author() {
    }

    public Author(int auid, String name, String from) {
        this.auid = auid;
        this.name = name;
        this.from = from;
    }

    public int getAuid() {
        return auid;
    }

    public void setAuid(int auid) {
        this.auid = auid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
    
}
