package www.zh.pojo;

import www.zh.common.Product;
import www.zh.util.FileAction;
import www.zh.dao.ProDao;
import www.zh.dao.ProDaoImpl;
import www.zh.util.ProUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet(name = "AddServlet",urlPatterns = "/add.do")
@MultipartConfig
public class AddServlet extends HttpServlet {
    private ProDao pd;

    @Override
    public void init() throws ServletException {
        pd = new ProDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        Part image = request.getPart("image");
        String img = FileAction.update(image);
        String des = request.getParameter("des");
        String stock = request.getParameter("stock");
        String date = request.getParameter("date");
        String category = request.getParameter("category");
        String factory = request.getParameter("factory");
        Product product = new Product(ProUtil.getProId(), name, Double.parseDouble(price), img, des, Integer.parseInt(stock), ProUtil.getStringConverseDate(date), Integer.valueOf(category), factory);
        pd.addProduct(product);
        response.sendRedirect("success.jsp");

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
