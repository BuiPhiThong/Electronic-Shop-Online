/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Author;
import model.Category;
import model.Product;
import model.Publisher;

/**
 *
 * @author BUI TUAN DAT
 */
public class SearchDAO extends DBContext {

   public List<Product> search(String key) {
    List<Product> list = new ArrayList<>();
    String sql = "SELECT * FROM Product WHERE 1=1";
    
    if (key != null && !key.equals("")) {
        sql += " AND (name LIKE ? OR describe LIKE ?)";
    }

    CategoryDAO cd = new CategoryDAO();
    PublisherDAO p = new PublisherDAO();
    AuthorDAO ad = new AuthorDAO();
    
    try {
        PreparedStatement st = connection.prepareStatement(sql);
        if (key != null && !key.equals("")) {
            st.setString(1, "%" + key + "%");
            st.setString(2, "%" + key + "%");
        }
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            Product pd = new Product();
            pd.setId(rs.getInt("id"));
            pd.setName(rs.getString("name"));
            pd.setPrice(rs.getDouble("price"));
            pd.setQuantity(rs.getInt("quantity"));
            pd.setDescribe(rs.getString("describe"));
            pd.setImage(rs.getString("image"));
            pd.setDom(rs.getDate("dom"));
            
            Category c = new Category();
            c.setId(rs.getInt("cid"));
            pd.setCid(c);
            
            int pid = (rs.getInt("pid"));
            Publisher pl = p.getPublisherbyId(pid);
            pd.setPid(pl);
            
            int authorid = rs.getInt("auid");
            Author a = ad.getAuthorbyId(authorid);
            pd.setAuid(a);

            list.add(pd);
        }
    } catch (SQLException e) {
        // Handle SQL exception
    }
    return list;
}
//    public List<Product> search(String key) {
//        List<Product> list = new ArrayList<>();
//        String sql = "select * from Product where 1=1";
//        if (key != null && !key.equals("")) {
//            sql += " and name like '%" + key + "%' or describe like '%" + key + "%'";
//        }
//
//        CategoryDAO cd = new CategoryDAO();
//        PublisherDAO p = new PublisherDAO();
//        AuthorDAO ad = new AuthorDAO();
//        try {
//            PreparedStatement st = connection.prepareStatement(sql);
//            ResultSet rs = st.executeQuery();
//            while (rs.next()) {
//
//                Product pd = new Product();
//                pd.setId(rs.getInt("id"));
//                pd.setName(rs.getString("name"));
//                pd.setPrice(rs.getDouble("price"));
//                pd.setQuantity(rs.getInt("quantity"));
//                pd.setDescribe(rs.getString("describe"));
//                pd.setImage(rs.getString("image"));
//                pd.setDom(rs.getDate("dom"));
////              int categoryid = (rs.getInt("cid"));
//                Category c = new Category();
//                c.setId(rs.getInt("cid"));
//                pd.setCid(c);
//                int pid = (rs.getInt("pid"));
//                Publisher pl = p.getPublisherbyId(pid);
//                pd.setPid(pl);
//                int authorid = rs.getInt("auid");
//                Author a = ad.getAuthorbyId(authorid);
//                pd.setAuid(a);
//
//                list.add(pd);
//            }
//        } catch (SQLException e) {
//        }
//        return list;
//    }

    public static void main(String[] args) {
        SearchDAO sd = new SearchDAO();
        String key="Tieu thuyet";
        List<Product> search= sd.search(key);
        for (Product product : search) {
            System.out.println(product.getDom());
        }
    }
}
