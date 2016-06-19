package servlets;

import models.Item;
import models.User;
import org.omg.CORBA.UserException;
import org.postgresql.util.PSQLException;
import store.ItemsRepository;
import store.UsersRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/AddItemServlet")
public class AddItemServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        String name = req.getParameter("nameItem");
        int price = Integer.parseInt(req.getParameter("priceItem"));
        String image = req.getParameter("imageItem");
        try{
            Item item = new Item(name,price,image);
            ItemsRepository storage = new ItemsRepository();
            storage.addItem(item);
            session.setAttribute("add","true");
            resp.sendRedirect(getServletContext().getContextPath() + "/AdminSelectServlet");

        }catch (SQLException ex){

        }

    }

}
