package www.zh.ajax;

import net.sf.json.JSONArray;
import www.zh.common.User;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServerServlet",urlPatterns = "/ser.do")
public class ServerServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        //客户端获取到服务端数据
//        resp.getWriter().write("{\"name\":\"林俊杰\",\"id\":1}");

        //ajax案例
        User user = new User(1,"Danny","123456");
        User user2 = new User(2,"Jenny","123456");
        User user3 = new User(3,"LiMing","123456");
        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user2);
        users.add(user3);
        JSONArray jsonArray = JSONArray.fromObject(users);
        resp.getWriter().write(jsonArray.toString());
    }
}
