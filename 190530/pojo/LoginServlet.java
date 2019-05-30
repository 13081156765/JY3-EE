package www.zh.pojo;

import www.zh.common.User;
import www.zh.dao.UserDaoImpl;
import www.zh.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {

        private UserDao ud;
        @Override
        public void init() throws ServletException {
            ud = (UserDao) new UserDaoImpl();
        }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String name = request.getParameter("name");
        String ps = request.getParameter("ps");
        User us = new User(name,ps);
        boolean login = ud.login(us);
        if (login == true){
            request.getRequestDispatcher("Test2.jsp").forward(request,response);
        }else {
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
