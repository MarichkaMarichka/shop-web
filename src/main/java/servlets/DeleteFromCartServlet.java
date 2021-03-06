package servlets;

import models.Item;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/DeleteFromCartServlet")
public class DeleteFromCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HttpSession session = req.getSession(true);
            Item item = new Item();
            int index = Integer.parseInt(req.getParameter("index"));
            List<Item> list = (ArrayList<Item>) session.getAttribute("cartList");
            list.remove(index);
            session.setAttribute("cartList", list);
            resp.sendRedirect(getServletContext().getContextPath() + "/cart.jsp");
        }catch (NullPointerException ex) {
            resp.sendRedirect(getServletContext().getContextPath() + "/login.jsp");
        }



    }


}
