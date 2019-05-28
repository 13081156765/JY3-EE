package www.zh.pojo;

import www.zh.common.Product;
import www.zh.util.ProUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "UpdateServlet",urlPatterns = "/us.do")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String image = request.getParameter("image");
        String des = request.getParameter("des");
        String stock = request.getParameter("stock");
        String date = request.getParameter("date");
        String category = request.getParameter("category");
        String factory = request.getParameter("factory");
        Product pro = new Product(id,name,Double.parseDouble(price),image,des,Integer.parseInt(stock), ProUtil.getStringConverseDate(date),Integer.parseInt(category),factory);
        request.setAttribute("pro",pro);
        request.getRequestDispatcher("alter.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
