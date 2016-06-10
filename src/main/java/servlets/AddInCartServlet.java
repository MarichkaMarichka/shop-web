package servlets;

import models.Item;
import models.User;
import org.omg.CORBA.UserException;
import org.postgresql.util.PSQLException;
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

@WebServlet("/AddInCartServlet")
public class AddInCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        Item item = new Item();

        item.setId_item(Integer.parseInt(req.getParameter("idItem")));
        List<Item> list = (ArrayList<Item>)session.getAttribute("cartList");
        list.add(item);
        session.setAttribute("cartList",list);
        resp.sendRedirect(getServletContext().getContextPath() + "/descript.jsp");



    }


}
