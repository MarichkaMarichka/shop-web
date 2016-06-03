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

@WebServlet("/RegServlet")
public class RegServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String psw = req.getParameter("pass");
        String submPsw = req.getParameter("submPass");
        String email = req.getParameter("email");
        long number = Integer.parseInt(req.getParameter("number"));
        User user = new User(login,psw,email,number);
        UsersRepository storage = new UsersRepository();

        try{
            if(this.checkIsEqualsPass(psw,submPsw,req)) {
                storage.addUser(user);
            }
            resp.sendRedirect(getServletContext().getContextPath() + "/registr.jsp");
        }catch(SQLException ex){
            HttpSession session = req.getSession(true);
            String value2 = "This user is already registered!";
            session.setAttribute("myData", value2) ;
            resp.sendRedirect(getServletContext().getContextPath() + "/registr.jsp");
        }


    }
    public boolean checkIsEqualsPass(String psw,String submPsw,HttpServletRequest req){
        boolean isEgual = true;
        if(psw.equals(submPsw)==false){
            isEgual = false;
            HttpSession session = req.getSession(true);
            String value1 = "Passwords are unequal!";
            session.setAttribute("notEquals", value1);
        }
        return isEgual;
    }


}
