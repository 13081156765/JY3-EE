package www.zh.com;

import www.zh.dao.Test2Dao;
import www.zh.dao.Test2DaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Test2",urlPatterns = "/Test2.do")
public class Test2 extends HttpServlet {
    Test2Dao td;
    @Override
    public void init() throws ServletException {
        td = new Test2DaoImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        td.regsiter(username,password);
        //跳转到登录页面
        request.getRequestDispatcher("Login.jsp").forward(request,response);
    }
}
