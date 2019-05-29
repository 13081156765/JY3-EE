package www.zh.pojo;

import www.zh.common.Product;
import www.zh.dao.ProDao;
import www.zh.dao.ProDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SelectServlet",urlPatterns = "/se.do")
public class SelectServlet extends HttpServlet {

    private ProDao pd;

    @Override
    public void init() throws ServletException {
        pd = new ProDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> allPro = pd.getAllPro();
        request.setAttribute("pros",allPro);
        request.getRequestDispatcher("selOnePro.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
