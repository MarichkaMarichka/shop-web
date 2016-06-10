package servlets;

import models.Item;
import org.omg.CORBA.UserException;
import org.postgresql.util.PSQLException;
import store.ItemsRepository;
import store.UsersRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/DescriptServlet")
public class DescriptServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        ItemsRepository storage = new ItemsRepository();
        Item item = storage.searchItemById(Integer.parseInt(req.getParameter("idItem")));

        session.setAttribute("idItem",item.getId_item());
        session.setAttribute("priceItem",item.getPrice() );
        session.setAttribute("imageItem",item.getImage() );
        session.setAttribute("nameItem",item.getName() );
        resp.sendRedirect(getServletContext().getContextPath() + "/descript.jsp");

    }



}
