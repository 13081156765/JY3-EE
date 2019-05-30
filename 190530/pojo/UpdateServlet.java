package www.zh.pojo;

import www.zh.dao.UserDaoImpl;
import www.zh.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateServlet",urlPatterns = "/update.do")
public class UpdateServlet extends HttpServlet {
    private UserDao ud;

    @Override
    public void init() throws ServletException {
        ud = new UserDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String id  = request.getParameter("id");
//        String name  = request.getParameter("name");
//        String psw  = request.getParameter("word");
//        User user1 = new User(name, psw, Integer.parseInt(id));
//        ud.update(user1);
//        response.sendRedirect("user.do");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
}
