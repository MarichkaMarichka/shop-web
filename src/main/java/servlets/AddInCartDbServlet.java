package servlets;

import models.Cart;
import models.Item;
import models.User;
import store.CartRepository;
import store.ItemsRepository;

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

@WebServlet("/AddInCartDbServlet")
public class AddInCartDbServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        int index = Integer.parseInt(req.getParameter("index"));
        List<Item> list = (ArrayList<Item>) session.getAttribute("cartList");
        int item_id = list.get(index).getId_item();

        int user_id = Integer.parseInt(session.getAttribute("id_user").toString());

        CartRepository storage = new CartRepository();
        Cart cart = new Cart(user_id, item_id);
        try {
            storage.addCart(cart);
        } catch (SQLException ex) {
        }catch (NullPointerException ex) {
            resp.sendRedirect(getServletContext().getContextPath() + "/login.jsp");
        }


        list.remove(index);
        session.setAttribute("cartList", list);
        resp.sendRedirect(getServletContext().getContextPath() + "/cart.jsp");


    }


}
