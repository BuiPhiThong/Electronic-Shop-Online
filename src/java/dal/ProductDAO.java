/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.Author;
import model.Cart;
import model.Category;
import model.Item;
import model.Product;
import model.Publisher;

/**
 *
 * @author BUI TUAN DAT
 */
public class ProductDAO extends DBContext {

    public List<Product> getProductByCid(int cid) {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT [id]\n"
                + "      ,[name]\n"
                + "      ,[price]\n"
                + "      ,[quantity]\n"
                + "      ,[describe]\n"
                + "      ,[image]\n"
                + "      ,[dom]\n"
                + "      ,[cid]\n"
                + "  FROM [dbo].[Product]\n"
                + "  where cid=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, cid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setPrice(rs.getDouble("price"));
                p.setQuantity(rs.getInt("quantity"));
                p.setDescribe(rs.getString("describe"));
                p.setImage(rs.getString("image"));
                p.setDom(rs.getDate("dom"));
                Category c = new Category();
                c.setId(rs.getInt("cid"));
                p.setCid(c);
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }

    public List<Product> getTop5ProductByCid(int cid) {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT TOP (5) [id]\n"
                + "      ,[name]\n"
                + "      ,[price]\n"
                + "      ,[quantity]\n"
                + "      ,[describe]\n"
                + "      ,[image]\n"
                + "      ,[dom]\n"
                + "      ,[cid]\n"
                + "  FROM [dbo].[Product]\n"
                + "  WHERE cid = ?\n"
                + "  ORDER BY id DESC";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, cid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setPrice(rs.getDouble("price"));
                p.setQuantity(rs.getInt("quantity"));
                p.setDescribe(rs.getString("describe"));
                p.setImage(rs.getString("image"));
                p.setDom(rs.getDate("dom"));
                Category c = new Category();
                c.setId(rs.getInt("cid"));
                p.setCid(c);
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }

    public Product getProductById(int id) {
        CategoryDAO cd = new CategoryDAO();
        PublisherDAO pd = new PublisherDAO();
        AuthorDAO ad = new AuthorDAO();
        String sql = "SELECT [id]\n"
                + "      ,[name]\n"
                + "      ,[price]\n"
                + "      ,[quantity]\n"
                + "      ,[describe]\n"
                + "      ,[image]\n"
                + "      ,[dom]\n"
                + "      ,[cid]\n"
                + "      ,[pid]\n"
                + "      ,[auid]\n"
                + "  FROM [dbo].[Product]\n"
                + "  where id=?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setPrice(rs.getDouble("price"));
                p.setQuantity(rs.getInt("quantity"));
                p.setDescribe(rs.getString("describe"));
                p.setImage(rs.getString("image"));
                p.setDom(rs.getDate("dom"));
                int cid = (rs.getInt("cid"));
                Category c = cd.getCategorybyId(cid);
                p.setCid(c);
                int pid = (rs.getInt("pid"));
                Publisher pl = pd.getPublisherbyId(pid);
                p.setPid(pl);
                int auid = rs.getInt("auid");
                Author a = ad.getAuthorbyId(auid);
                p.setAuid(a);
                return p;
            }

        } catch (SQLException e) {
        }
        return null;
    }

   
    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        CategoryDAO cd = new CategoryDAO();
        PublisherDAO p = new PublisherDAO();
        AuthorDAO ad = new AuthorDAO();
        String sql = "SELECT [id]\n"
                + "      ,[name]\n"
                + "      ,[price]\n"
                + "      ,[quantity]\n"
                + "      ,[describe]\n"
                + "      ,[image]\n"
                + "      ,[dom]\n"
                + "      ,[cid]\n"
                + "      ,[pid]\n"
                + "      ,[auid]\n"
                + "  FROM [dbo].[Product]";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
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
                int cid = (rs.getInt("cid"));
                Category c = cd.getCategorybyId(cid);
                pd.setCid(c);
                int pid = (rs.getInt("pid"));
                Publisher pl = p.getPublisherbyId(pid);
                pd.setPid(pl);
                int auid = rs.getInt("auid");
                Author a = ad.getAuthorbyId(auid);
                pd.setAuid(a);

                list.add(pd);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }
    public Product getTop1Product() {
        CategoryDAO cd = new CategoryDAO();
        PublisherDAO p = new PublisherDAO();
        AuthorDAO ad = new AuthorDAO();
        String sql = "SELECT TOP (1) [id]\n"
                + "      ,[name]\n"
                + "      ,[price]\n"
                + "      ,[quantity]\n"
                + "      ,[describe]\n"
                + "      ,[image]\n"
                + "      ,[dom]\n"
                + "      ,[cid]\n"
                + "      ,[pid]\n"
                + "      ,[auid]\n"
                + "  FROM [dbo].[Product]"
                + "  ORDER BY id DESC";


        try {
            PreparedStatement st = connection.prepareStatement(sql);
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
                int cid = (rs.getInt("cid"));
                Category c = cd.getCategorybyId(cid);
                pd.setCid(c);
                int pid = (rs.getInt("pid"));
                Publisher pl = p.getPublisherbyId(pid);
                pd.setPid(pl);
                int auid = rs.getInt("auid");
                Author a = ad.getAuthorbyId(auid);
                pd.setAuid(a);

                return pd;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }
    public void insert(Product p) {
        String sql = "INSERT INTO [dbo].[Product]\n"
                + "           ([name]\n"
                + "           ,[price]\n"
                + "           ,[quantity]\n"
                + "           ,[describe]\n"
                + "           ,[image]\n"
                + "           ,[dom]\n"
                + "           ,[cid]\n"
                + "           ,[pid]\n"
                + "           ,[auid])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);

            st.setString(1, p.getName());
            st.setDouble(2, p.getPrice());
            st.setInt(3, p.getQuantity());
            st.setString(4, p.getDescribe());
            st.setString(5, p.getImage());
            st.setDate(6, new java.sql.Date(p.getDom().getTime()));
            st.setInt(7, p.getCid().getId());
            st.setInt(8, p.getPid().getPid());
            st.setInt(9, p.getAuid().getAuid());

            st.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void update(Product p) {
        String sql = "UPDATE [dbo].[Product]\n"
                + "   SET [name] = ?\n"
                + "      ,[price] = ?\n"
                + "      ,[quantity] = ?\n"
                + "      ,[describe] = ?\n"
                + "      ,[image] = ?\n"
                + "      ,[dom] = ?\n"
                + "      ,[cid] = ?\n"
                + "      ,[pid] = ?\n"
                + "      ,[auid] = ?\n"
                + " where id=?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, p.getName());
            st.setDouble(2, p.getPrice());
            st.setInt(3, p.getQuantity());
            st.setString(4, p.getDescribe());
            st.setString(5, p.getImage());
            st.setDate(6, new java.sql.Date(p.getDom().getTime()));
            st.setInt(7, p.getCid().getId());
            st.setInt(8, p.getPid().getPid());
            st.setInt(9, p.getAuid().getAuid());
            st.setInt(10, p.getId());

            st.executeUpdate();
        } catch (SQLException e) {
        }

    }

    //delete product
    public void delete(int id) {
        String sql = "Delete from Product where id=?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);

            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    //tao order
    public void addOrder(Account c, Cart cart) {
        LocalDate currentDate = LocalDate.now();

        String date = currentDate.toString();

        try {
            // add vao bang ordertruoc

            String sql = "insert into [order] values(?,?,?)";
            PreparedStatement st = connection.prepareStatement(sql);

            st.setString(1, date);
            st.setInt(2, c.getAid());
            st.setDouble(3, cart.getTotalMoney());

            st.executeUpdate();
            //lay ra id cua Order ben tren vua add

            String sql1 = "select top 1 id from [order] order by id desc";
            PreparedStatement st1 = connection.prepareStatement(sql1);

            ResultSet rs = st1.executeQuery();

            //add bangOrderDetail
            if (rs.next()) {
                int oid = rs.getInt("id");
                for (Item i : cart.getItems()) {
                    String sql2 = "insert into [orderline] values(?,?,?,?)";
                    PreparedStatement st2 = connection.prepareStatement(sql2);
                    st2.setInt(1, oid);
                    st2.setInt(2, i.getProduct().getId());
                    st2.setInt(3, i.getQuantity());
                    st2.setDouble(4, i.getPrice());

                    st2.executeUpdate();
                }
            }
            String sql3 = "update product set quantity=quantity-? where id=?";
            PreparedStatement st3 = connection.prepareStatement(sql3);

            for (Item i : cart.getItems()) {
                st3.setInt(1, i.getQuantity());
                st3.setInt(2, i.getProduct().getId());

                st3.executeUpdate();
            }
        } catch (SQLException e) {
        }
    }
    public List<Product> getProductsPerPage(int startIndex, int productsPerPage) {
    List<Product> products = new ArrayList<>();
    CategoryDAO cd = new CategoryDAO();
    PublisherDAO p = new PublisherDAO();
    AuthorDAO ad = new AuthorDAO();
    String sql = "SELECT [id]\n"
            + "      ,[name]\n"
            + "      ,[price]\n"
            + "      ,[quantity]\n"
            + "      ,[describe]\n"
            + "      ,[image]\n"
            + "      ,[dom]\n"
            + "      ,[cid]\n"
            + "      ,[pid]\n"
            + "      ,[auid]\n"
            + "  FROM [dbo].[Product]"
            + "  ORDER BY id"
            + "  OFFSET ? ROWS"
            + "  FETCH NEXT ? ROWS ONLY";

    try {
        PreparedStatement st = connection.prepareStatement(sql);
        st.setInt(1, startIndex);
        st.setInt(2, productsPerPage);
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
            int cid = (rs.getInt("cid"));
            Category c = cd.getCategorybyId(cid);
            pd.setCid(c);
            int pid = (rs.getInt("pid"));
            Publisher pl = p.getPublisherbyId(pid);
            pd.setPid(pl);
            int auid = rs.getInt("auid");
            Author a = ad.getAuthorbyId(auid);
            pd.setAuid(a);

            products.add(pd);
        }
    } catch (SQLException e) {
        System.out.println(e);
    }

    return products;
}
public int getTotalProducts() {
    int total = 0;
    String sql = "SELECT COUNT(*) AS total FROM [dbo].[Product]";
    try {
        PreparedStatement st = connection.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        if (rs.next()) {
            total = rs.getInt("total");
        }
    } catch (SQLException e) {
        System.out.println(e);
    }
    return total;
}


    public static void main(String[] args) {
        int id = 1;
        ProductDAO d = new ProductDAO();
        Product s = d.getProductById(id);
        System.out.println(s.getAuid().getName());
    }
}
