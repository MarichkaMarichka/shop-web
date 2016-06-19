package servlets;

import models.Item;
import store.ItemsRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/AdminSelectServlet")
public class AdminSelectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int page = 1;
        int recordsPerPage = 3;
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
        RequestDispatcher view = req.getRequestDispatcher("admin.jsp");
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
