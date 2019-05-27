package www.zh.everyday;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "TimeServlet",urlPatterns = "/time.do")
public class TimeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String str = sdf.format(date);
        Cookie coo = new Cookie("time",str);
        coo.setPath("/");
        coo.setMaxAge(60*60*24*7*365);
        resp.addCookie(coo);
        Cookie[] coos = req.getCookies();
        if (null != coos){
            String time = null;
            for (Cookie c:coos) {
                if ("time".equals(c.getName())){
                    time = c.getValue();
                }
            }
            if (null != time){
                resp.getWriter().write("上次登陆时间为："+time);
            } else{
                resp.getWriter().write("欢迎您首次登录");
            }
        }
    }
}
