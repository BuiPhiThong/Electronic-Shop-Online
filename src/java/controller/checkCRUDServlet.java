
package controller;

import dal.CategoryDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Category;

/**
 *
 * @author BUI TUAN DAT
 */
@WebServlet(name="checkCRUDServlet", urlPatterns={"/check"})
public class checkCRUDServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        CategoryDAO cd = new CategoryDAO();
        if (session.getAttribute("account") == null) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            String action = request.getParameter("action");
            if (action != null && action.equals("addcategory")) {
                request.getRequestDispatcher("ccrud").forward(request, response);
            }
//            if (action.equals("delete")) {
//                String id_raw = request.getParameter("id");
//                int id;
//                try {
//                    id = Integer.parseInt(id_raw);
//                    cd.delete(id);
//                    request.getRequestDispatcher("list").forward(request, response);
//                } catch (IOException e) {
//                }
//            }
//            if (action.equals("update")) {
//                String id_raw = request.getParameter("id");
//                int id;
//                try {
//                    id = Integer.parseInt(id_raw);
//                    Category c =cd.getCategorybyId(id);
//                    request.setAttribute("upd", c);
//                    request.getRequestDispatcher("update.jsp").forward(request, response);
//                } catch (NumberFormatException e) {
//                }
//            }
        }
    }


}
