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
@WebServlet(name = "detailProductServlet", urlPatterns = {"/detailproduct"})
public class detailProductServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        HttpSession session = request.getSession();
//        if(session.getAttribute("errorquantity")!=null){
//            session.removeAttribute("errorquantity");
//        }
       
        String id_raw = request.getParameter("pid");
        ProductDAO pd = new ProductDAO();
        try {
            int id = Integer.parseInt(id_raw);
            Product p = pd.getProductById(id);
            List<Product> list= pd.getProductByCid(p.getCid().getId());
            request.setAttribute("detailproduct", p);
            request.setAttribute("similarproduct", list);
        } catch (NumberFormatException e) {
        }
        request.getRequestDispatcher("detailproduct.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
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
