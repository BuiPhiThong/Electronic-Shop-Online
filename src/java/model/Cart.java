/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BUI TUAN DAT
 */
public class Cart {
    private List<Item> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public List<Item> getItems() {
        return items;
    }

    // Lay ra item theo id
    public Item getItemById(int id) {
        for (Item i : items) {
            if (i.getProduct().getId() == id) {
                return i;
            }
        }
        return null;
    }

    //Lay ra so luong san pham co trong gio hang 
    public int getQuantityById(int id) {
        return getItemById(id).getQuantity();
    }

    // addItem kiểm tra xem mặt hàng đang được thêm đã có trong giỏ hàng hay chưa dựa trên ID sản phẩm.
    // Nếu có, nó sẽ tăng số lượng của mặt hàng hiện có; nếu không, nó sẽ thêm mặt hàng mới vào giỏ hàng
    public void addItem(Item i) {
        if (getItemById(i.getProduct().getId()) != null) {
            Item t = getItemById(i.getProduct().getId());

            t.setQuantity(t.getQuantity() + i.getQuantity());
        } else {
            items.add(i);
        }
    }

    // xoa san pham khoi gio hang
    public void removeItem(int id) {
        if (getItemById(id) != null) {
            items.remove(getItemById(id));
        }
    }

    //tra ve toan bo tien cua hoa don(tong tien cua hoa don)
    public double getTotalMoney() {
        double t = 0;
        for (Item i : items) {
            t += (i.getQuantity() * i.getPrice());
        }

        return t;
    }

    //
    private Product getProductById(int id, List<Product> list) {
        for (Product i : list) {
            if (i.getId() == id) {
                return i;
            }
        }
        return null;
    }
    //tu cookie ta se lay ra duoc item
    
    // muon tao cart,ta can 
    
    public Cart(String txt, List<Product> list) 
    {
        items = new ArrayList<>();

        try {
            if (txt != null && txt.length() != 0) {
                String[] s = txt.split("/");//chia danh sach cookie san ppham
                for (String i : s)//duyet tung san spham 
                {
                    String[] n = i.split(":");
                    int id =Integer.parseInt(n[0]);
                    int quantity=Integer.parseInt(n[1]);
                    Product p = getProductById(id, list);
                    Item t = new Item(p, quantity, p.getPrice());
                    addItem(t);
                }
            }
        } catch (NumberFormatException e) {
        }

    }

}
