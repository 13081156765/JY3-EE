package www.zh.servlet;

import www.zh.common.User;
import www.zh.dao.UserDao;
import www.zh.dao.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpDateServlet",urlPatterns = "/uds.do")
public class UpDateServlet extends HttpServlet {

    private UserDao ud;

    @Override
    public void init() throws ServletException {
        ud = new UserDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id1 = request.getParameter("in");
        String username1 = request.getParameter("u");
        String password1 = request.getParameter("p");
//        System.out.println(id1);
//        System.out.println(username1);
//        System.out.println(password1);
        User user1 = new User(Integer.parseInt(id1),username1,password1);
        ud.up(user1);
//        System.out.println(user1);
        response.sendRedirect("us.do");
}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
