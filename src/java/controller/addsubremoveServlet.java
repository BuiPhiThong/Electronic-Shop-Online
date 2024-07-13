/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Cart;
import model.Item;
import model.Product;

/**
 *
 * @author BUI TUAN DAT
 */
@WebServlet(name="addsubremoveServlet", urlPatterns={"/process"})
public class addsubremoveServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductDAO d = new ProductDAO();
        List<Product> list = d.getAllProduct();
        Cookie[] arr = request.getCookies();
        String txt = "";

        if (arr != null) {
            for (Cookie o : arr) {
                if (o.getName().equals("cart")) {
                    txt += o.getValue();
                    o.setMaxAge(0);
                    response.addCookie(o);
                }
            }
        }
        Cart cart = new Cart(txt, list);
        String num_raw = request.getParameter("num");
        String id_raw = request.getParameter("id");
        int id, num = 0;
        // bat dau xuly cong tru
        //xoa cookie va add lai
        String errorQuantity="";
        try {
            id = Integer.parseInt(id_raw);
            Product p = d.getProductById(id);
            int numstore = p.getQuantity();//ktr xem con k roi tang giam

            num = Integer.parseInt(num_raw);
            if (num == -1 && (cart.getQuantityById(id)) <= 1) {
                //giam san pham trong gio hang toi 1 thi bi loai bo
                cart.removeItem(id);
            } else {
                if (num == 1 && cart.getQuantityById(id) >= numstore) {
                    num = 0;//so luong mua vuot qua kho => k them vao gio
//                    errorQuantity="San pham da vuot quá kho";
                }
                //sp mua chua dat toi gioi han nhay ra khoi if nay
                double price = p.getPrice() * 3;
                Item t = new Item(p, num, price);
                cart.addItem(t);
            }
        } catch (NumberFormatException e) {
        }
        // luu lai vao cookie tat ca su thay doi cong tru
        List<Item> items = cart.getItems();
        txt = "";

        if (items.size() > 0)//da co it nhat 1 spham
        {
            txt = items.get(0).getProduct().getId() + ":"
                    + items.get(0).getQuantity();
            for (int i = 1; i < items.size(); i++) {
                txt += "/" + items.get(i).getProduct().getId() + ":"
                        + items.get(i).getQuantity();
            }

        }
        Cookie c = new Cookie("cart", txt);
        c.setMaxAge(2 * 24 * 60 * 60);
        response.addCookie(c);
        request.setAttribute("cart", cart);   
        request.getRequestDispatcher("mycart.jsp").forward(request, response);
    }

        protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductDAO d = new ProductDAO();
        List<Product> list = d.getAllProduct();
        Cookie[] arr = request.getCookies();
        String txt = "";

        if (arr != null) {
            for (Cookie o : arr) {
                if (o.getName().equals("cart")) {
                    txt += o.getValue();
                    o.setMaxAge(0);
                    response.addCookie(o);
                }
            }
        }
        //xoa
        String id = request.getParameter("id");
        String[] ids = txt.split("/");

        String out = "";
        for (int i = 0; i < ids.length; i++) {
            String[] s = ids[i].split(":");

            if (!s[0].equals(id)) {
                if (out.isEmpty()) {
                    out = ids[i];
                } else {
                    out += "/" + ids[i];
                }
            }
        }
        if (!out.isEmpty()) {
            Cookie c = new Cookie("cart", out);
            c.setMaxAge(2 * 24 * 60 * 60);
            response.addCookie(c);
        }
        Cart cart = new Cart(out, list);

        request.setAttribute("cart", cart);

        request.getRequestDispatcher("mycart.jsp").forward(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
