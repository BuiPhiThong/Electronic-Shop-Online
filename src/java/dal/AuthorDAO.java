/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.SQLException;
import model.Author;
import model.Category;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author BUI TUAN DAT
 */
public class AuthorDAO extends DBContext{
    public Author getAuthorbyId(int id) {
        String sql = "select * from Author where id=?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Author c = new Author(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("from"));
                return c;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
}
