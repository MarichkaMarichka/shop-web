package servlets;

import models.User;
import store.UsersRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/RegServlet")
public class RegServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String psw = req.getParameter("pass");
        String submPsw = req.getParameter("submPass");
//        if(psw.equals(submPsw)==false){
//            HttpSession session = req.getSession(true);
//            String value = "Passwords is unequal!";
//            session.setAttribute("isEquals", value);
//        }
        String email = req.getParameter("email");
        long number = Integer.parseInt(req.getParameter("number"));
        User user = new User(login,psw,email,number);
        UsersRepository storage = new UsersRepository();
        try{
            storage.addUser(user);
            resp.sendRedirect(getServletContext().getContextPath() + "/registr.jsp");
        }catch(Exception ex){
            HttpSession session = req.getSession(true);
            String value = "This user is already registered!";
            session.setAttribute("myData", value);
        }

    }
}
