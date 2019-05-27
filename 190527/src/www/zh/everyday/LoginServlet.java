package www.zh.everyday;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/go.do")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String u = req.getParameter("username");
        String p = req.getParameter("password");
        if (null != u && null != p){
            Cookie user = new Cookie("username",u);
            Cookie pass = new Cookie("password", p);
            user.setMaxAge(60*60*24);
            pass.setMaxAge(60*60*24);
            resp.addCookie(user);
            resp.addCookie(pass);
        } else {
            Cookie[] coos = req.getCookies();
            for (Cookie c:coos) {
                if ("username".equals(c.getName())){
                    u = c.getValue();
                }
                if ("password".equals(c.getName())){
                    p = c.getValue();
                }
            }
        }
        if (u != null && p != null){
            req.getRequestDispatcher("HomePage.jsp").forward(req,resp);
        } else {
            req.getRequestDispatcher("Login.jsp").forward(req,resp);
        }
    }
}
