/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Publisher;

/**
 *
 * @author BUI TUAN DAT
 */
public class PublisherDAO extends DBContext{
    public Publisher getPublisherbyId(int id) {
        String sql = "select * from Publisher where id=?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Publisher c = new Publisher(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("address"),
                rs.getString("phone"));
                return c;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
}
