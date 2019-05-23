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

@WebServlet(name = "DeleteServlet",urlPatterns ="/ds.do")
public class DeleteServlet extends HttpServlet {

    private UserDao ud;

    @Override
    public void init() throws ServletException {
        ud = new UserDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id2 = request.getParameter("id");
       // System.out.println(id2);
        int i = Integer.parseInt(id2);
        ud.del(i);
        response.sendRedirect("/us.do");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doPost(request,response);
    }
}
