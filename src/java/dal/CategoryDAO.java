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
import model.Account;
import model.Category;

/**
 *
 * @author BUI TUAN DAT
 */
public class CategoryDAO extends DBContext {

    public void insert(Category c) {
        String sql = "INSERT INTO [dbo].[Category]\n"
                + "           ([name]\n"
                + "           ,[describe])\n"
                + "     VALUES\n"
                + "           (?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            //set cho 5 dau ?
            st.setString(1, c.getName());
            st.setString(2, c.getDescribe());

            st.executeUpdate();//khi insert,dele,upd deu dung lenh nay
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void update(Category c) {
        String sql = "UPDATE [dbo].[Category]\n"
                + "   SET [name] = ?\n"
                + "      ,[describe] = ?\n"
                + " where id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, c.getName());
            st.setString(2, c.getDescribe());
            st.setInt(3, c.getId());
            st.executeQuery();
        } catch (SQLException e) {
        }
    }
    //xoa Category
    public void delete(int id){
        String sql="Delete from Category where id=?";
        
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);

            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        String sql = "select * from Category";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Category c = new Category(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("describe"));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public Category getCategorybyId(int id) {

        String sql = "select * from Category where id=?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Category c = new Category(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("describe"));
                return c;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;

    }

    public static void main(String[] args) {
        CategoryDAO d = new CategoryDAO();
        System.out.println(new CategoryDAO().getCategorybyId(1).getName());

    }
}
