package servlets;

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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String psw = req.getParameter("pass");


        User user = new User(login,psw);
        UsersRepository storage = new UsersRepository();
            if(storage.searchUserByLogPass(user)) {
                resp.sendRedirect(getServletContext().getContextPath() + "/home.jsp");
            } else {
                HttpSession session = req.getSession(true);
                String value2 = "This user is not registered!";
                session.setAttribute("myData", value2);
                resp.sendRedirect(getServletContext().getContextPath() + "/login.jsp");
            }


    }


}
