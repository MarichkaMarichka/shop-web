package servlets;

import models.Item;
import store.ItemsRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/DeleteItemServlet")
public class DeleteItemServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        int id = Integer.parseInt(req.getParameter("idItem"));
        try{
            Item item = new Item(id);
            ItemsRepository storage = new ItemsRepository();
            storage.deleteItem(item);
            resp.sendRedirect(getServletContext().getContextPath() + "/AdminSelectServlet");

        }catch (SQLException ex){
            String inCart = "This item can't be deleted. It is in cart!";
            session.setAttribute("inCart",inCart);
            resp.sendRedirect(getServletContext().getContextPath() + "/AdminSelectServlet");
        }

    }

}
