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
public class AccountDAO extends DBContext {

    //lam trang dangky
    public void resgister(Account a) {
        String sql = "INSERT INTO [dbo].[Account]\n"
                + "           ([name]\n"
                + "           ,[amount]\n"
                + "           ,[username]\n"
                + "           ,[password]\n"
                + "           ,[role])\n"
                + "     VALUES(?,?,?,?,?)";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, a.getName());
            st.setDouble(2, a.getAmount());
            st.setString(3, a.getUsername());
            st.setString(4, a.getPassword());
            st.setInt(5, a.getRole());

            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    //check úsertontai
    public boolean ExitsedUser_check(String username) {
        String sql = "SELECT [id]\n"
                + "      ,[name]\n"
                + "      ,[amount]\n"
                + "      ,[username]\n"
                + "      ,[password]\n"
                + "      ,[role]\n"
                + "  FROM [dbo].[Account]\n"
                + "  where username=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            
        }

        return false;
    }

    public List<Account> getAllAccount() {
        List<Account> list = new ArrayList<>();
        String sql = "SELECT [id]\n"
                + "      ,[name]\n"
                + "      ,[amount]\n"
                + "      ,[username]\n"
                + "      ,[password]\n"
                + "      ,[role]\n"
                + "  FROM [dbo].[Account]";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Account a = new Account(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("amount"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getInt("role"));
                list.add(a);
            }
        } catch (Exception e) {
        }

        return list;
    }

    public Account getAccountById(int id) {

        String sql = "SELECT [id]\n"
                + "      ,[name]\n"
                + "      ,[amount]\n"
                + "      ,[username]\n"
                + "      ,[password]\n"
                + "      ,[role]\n"
                + "  FROM [dbo].[Account]\n"
                + "  where id=?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Account a = new Account(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("amount"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getInt("role"));
                return a;
            }
        } catch (SQLException e) {
        }

        return null;
    }

    public void insert(Account c) {
        String sql = "INSERT INTO [dbo].[Account]\n"
                + "           ([name]\n"
                + "           ,[amount]\n"
                + "           ,[username]\n"
                + "           ,[password]\n"
                + "           ,[role])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            //set cho 5 dau ?
            st.setString(1, c.getName());
            st.setDouble(2, c.getAmount());
            st.setString(3, c.getUsername());
            st.setString(4, c.getPassword());
            st.setInt(5, c.getRole());
            st.executeUpdate();//khi insert,dele,upd deu dung lenh nay
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    //update a account
    public void update(Account a) {
        String sql = "UPDATE [dbo].[Account]\n"
                + "   SET [name] = ?\n"
                + "      ,[amount] = ?\n"
                + "      ,[username] = ?\n"
                + "      ,[password] = ?\n"
                + "      ,[role] = ?\n"
                + " WHERE id=?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);

            st.setString(1, a.getName());
            st.setDouble(2, a.getAmount());
            st.setString(3, a.getUsername());
            st.setString(4, a.getPassword());
            st.setInt(5, a.getRole());
            st.setInt(6, a.getAid());
            st.executeUpdate();
        } catch (SQLException e) {
        }
    }

    //xoa account
    public void delete(int id) {
        String sql = "Delete from Account where id=?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);

            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Account check(String username, String password) {
        String sql = "SELECT [id]\n"
                + "      ,[name]\n"
                + "      ,[amount]\n"
                + "      ,[username]\n"
                + "      ,[password]\n"
                + "      ,[role]\n"
                + "  FROM [dbo].[Account]\n"
                + "  where username=? and password=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Account a = new Account(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("amount"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getInt("role"));

                return a;
            }

        } catch (SQLException e) {
        }
        return null;
    }

    public void change(Account a) {
        String sql = "update account set password=? where username=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, a.getPassword());
            st.setString(2, a.getUsername());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        int id = 1;
        AccountDAO ad = new AccountDAO();
        Account a = ad.getAccountById(id);

        System.out.println(a.getName());
    }
}
