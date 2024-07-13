/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Order;
import model.OrderLine;
import model.Product;

/**
 *
 * @author ASUS
 */
public class OrderDAO extends DBContext {

    public List<Order> getAllOrder() {
        List<Order> list = new ArrayList<>();
        String sql = "select * from [Order]";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Order o = new Order(rs.getInt("id"),
                        rs.getString("date"),
                        rs.getInt("aid"),
                        rs.getDouble("totalmoney"));
                list.add(o);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<OrderLine> getOrderLineById(int oid) {
        List<OrderLine> list = new ArrayList<>();
        String sql = "select o.oid, o.pid, p.name, o.quantity, o.price from orderline o join\n"
                + "Product p on o.pid = p.id where o.oid = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, oid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                OrderLine ol = new OrderLine();
                ol.setOid(rs.getInt(1));
                ol.setPid(rs.getInt(2));
                ol.setpName(rs.getString(3));
                ol.setQuantity(rs.getInt(4));
                ol.setPrice(rs.getDouble(5));
                list.add(ol);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public static void main(String[] args) {
        OrderDAO o = new OrderDAO();
        System.out.println(o.getOrderLineById(2));
    }
}
