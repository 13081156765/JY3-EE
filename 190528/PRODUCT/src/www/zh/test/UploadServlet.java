package www.zh.test;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

@WebServlet(name = "UploadServlet",urlPatterns = "/upload.do")
@MultipartConfig
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //修改编码格式
        request.setCharacterEncoding("UTF-8");
        Part file1 = request.getPart("file1");
        //获取提交的文件名
        String sub = file1.getSubmittedFileName();
//        System.out.println(sub);
        //IO流
        InputStream is = file1.getInputStream();
        //创建UUID
        UUID uu = UUID.randomUUID();
        OutputStream os = new FileOutputStream("E:\\学习环境\\terraceimg\\"+uu+" "+sub);
        //(完全不会)
        int buffer = 0;
        byte[] bs = new byte[1024];
        while ((buffer = is.read(bs)) != -1){
            os.write(bs,0,buffer);
        }
        os.close();
        is.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
