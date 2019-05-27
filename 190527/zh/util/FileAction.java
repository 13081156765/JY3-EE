package www.zh.util;

import javax.servlet.http.Part;
import java.io.*;
import java.util.UUID;

public class FileAction {

    public static String update(Part part){
        //获取提交的文件名
        String sub = part.getSubmittedFileName();
//        System.out.println(sub);
        InputStream is = null;
        //创建UUID
        UUID uu = UUID.randomUUID();
        OutputStream os = null;
        String name = uu+sub;
        try {
            //IO流
            is = part.getInputStream();
            os = new FileOutputStream("E:\\学习环境\\terraceimg\\"+name);
            //(完全不会)
            int buffer = 0;
            byte[] bs = new byte[1024];
            while ((buffer = is.read(bs)) != -1) {
                os.write(bs, 0, buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return name;
    }

}
