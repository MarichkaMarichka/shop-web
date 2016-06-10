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

@WebServlet("/SelectServlet")
public class SelectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int page = 1;
        int recordsPerPage = 8;
        if(req.getParameter("page") != null)
            page = Integer.parseInt(req.getParameter("page"));
        ItemsRepository storage = new ItemsRepository();
        List<Item> list = storage.selectItems((page-1)*recordsPerPage,
                recordsPerPage);
        int noOfRecords = storage.countRecords();
        int noOfPages = countPages(noOfRecords,recordsPerPage);
        req.setAttribute("itemList", list);
        req.setAttribute("noOfPages", noOfPages);
        req.setAttribute("currentPage", page);
        RequestDispatcher view = req.getRequestDispatcher("home.jsp");
        view.forward(req, resp);


    }
    public int countPages(int countRecords,int recordsPerPage){
        int countPages = 0;
        if((countRecords%recordsPerPage)==0){
            countPages = countRecords/recordsPerPage;
        }else{
            countPages = countRecords/recordsPerPage+1;
        }
        return countPages;
    }



}
