package www.zh.com;

import www.zh.dao.Test2Dao;
import www.zh.dao.Test2DaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/Login.do")
public class LoginServlet extends HttpServlet {
    Test2Dao td;
    @Override
    public void init() throws ServletException {
        td = new Test2DaoImpl();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User us = td.login(new User(username,password));
        if (null != us){
            request.getRequestDispatcher("Test2.jsp").forward(request,response);
        }else {
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }

    }
}
