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
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Product;

/**
 *
 * @author BUI TUAN DAT
 */
@WebServlet(name = "buyProductServlet", urlPatterns = {"/buy"})
public class buyProductServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet buyProductServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet buyProductServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ProductDAO d = new ProductDAO();
        List<Product> list = d.getAllProduct();
        Cookie[] arr = request.getCookies();
        String txt = "";

        String num = request.getParameter("num");
        String id = request.getParameter("id");
        boolean cartCookieExists = false;
        int idhidden, numcheck;
        try {
            idhidden = Integer.parseInt(id);
            Product p = d.getProductById(idhidden);
            numcheck = Integer.parseInt(num);
//            if (p.getQuantity() < numcheck) {
////                HttpSession session = request.getSession();
////                session.setAttribute("errorquantity", "Số lượng mua vượt quá kho");
////                response.sendRedirect("detailproduct?pid=" + id);
//                request.setAttribute("errorquantity", "Số lượng mua vượt quá kho");
//                request.getRequestDispatcher("detailproduct").forward(request, response);
//                return;
//            }

//            if (p.getQuantity() < numcheck) {
//                request.setAttribute("errorquantity", "Số lượng mua vượt quá kho");
//                request.getRequestDispatcher("detailproduct?pid=" + id).forward(request, response);
//                return;
//            }
            if (p.getQuantity() < numcheck) {
                response.sendRedirect("detailproduct?pid=" + id + "&error=quantity_exceeded");
                return;
            }

        } catch (NumberFormatException e) {
            System.out.println(e);
            response.getWriter().print(e);
        }
        
        
        if (arr != null) {
            for (Cookie o : arr) {
                if (o.getName().equals("cart")) {
                    txt = o.getValue();
                    cartCookieExists = true;
                    break;
                }
            }
        }

        //nguoi dung da chon spham de mua
        //chuan bi them thong tin vao gio hang
        if ((id != null) && (num != null)) {
            if (txt.isEmpty()) 
            {
                // Lần đầu thêm vào giỏ hàng
                txt = id + ":" + num;
            } else {
                // Các mặt hàng bổ sung được thêm vào giỏ hàng
                txt = txt + "/" + id + ":" + num;
            }
        }

        Cookie c = new Cookie("cart", txt);
        c.setMaxAge(2 * 24 * 60 * 60);
        response.addCookie(c);
        HttpSession session = request.getSession();
        if(session.getAttribute("account") == null){
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        response.sendRedirect("home");

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
