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

@WebServlet("/EditItemServlet")
public class EditItemServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        int id = Integer.parseInt(session.getAttribute("idItem").toString());
        String image = req.getParameter("imageItem");
        try{
            Item item = new Item(id,image);
            ItemsRepository storage = new ItemsRepository();
            storage.updateItem(item);
            resp.sendRedirect(getServletContext().getContextPath() + "/AdminSelectServlet");

        }catch (SQLException ex){

        }

    }

}
