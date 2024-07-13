/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.AuthorDAO;
import dal.CategoryDAO;
import dal.ProductDAO;
import dal.PublisherDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;
import java.sql.Date;
import model.Author;
import model.Category;
import model.Publisher;

/**
 *
 * @author BUI TUAN DAT
 */
@WebServlet(name = "addProductCRUD", urlPatterns = {"/addproduct"})
public class addProductServlet extends HttpServlet {

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
            out.println("<title>Servlet addProductCRUD</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addProductCRUD at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //String id_raw = request.getParameter("id");
        String name = request.getParameter("name");
        String price_raw = request.getParameter("price");
        String quantity_raw = request.getParameter("quantity");
        String describe = request.getParameter("describe");
        String image = request.getParameter("image");
        String dom_raw = request.getParameter("dom");
        String cid_raw = request.getParameter("cid");
        String pid_raw = request.getParameter("pid");
        String auid_raw = request.getParameter("auid");
        ProductDAO pd = new ProductDAO();
        CategoryDAO cd = new CategoryDAO();
        AuthorDAO ad = new AuthorDAO();
        PublisherDAO pl = new PublisherDAO();
        int id, quantity, cid, pid, auid;
        double price;
        Date dom = null;
        try {
            //id = Integer.parseInt(id_raw);
            quantity = Integer.parseInt(quantity_raw);
            price = Double.parseDouble(price_raw);
            cid = Integer.parseInt(cid_raw);
            pid = Integer.parseInt(pid_raw);
            auid = Integer.parseInt(auid_raw);
            dom=Date.valueOf(dom_raw);
            //Product p = pd.getProductById(id);
            Category c = cd.getCategorybyId(cid);
            Author a = ad.getAuthorbyId(auid);
            Publisher pb = pl.getPublisherbyId(pid);
            //if (p == null) {
                Product p1 = new Product(name, price, quantity, describe, image, dom, c, pb, a);
                pd.insert(p1);
                response.sendRedirect("pcrud");
            //} else {
             
            //}
        } catch (NumberFormatException e) {

        }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
