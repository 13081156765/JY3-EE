package www.zh.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;

public class ProUtil {

    //将字符串类型的日期转换成DATE类型的方法
    public static Date getStringConverseDate(String str){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date parse = null;
        Date date = null;
        try {
            parse = sdf.parse(str);
            date = new Date(parse.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    //拿到商品ID
    public static void main(String[] args) {
        String proId = getProId();
        System.out.println(proId);
    }
    public static String getProId(){
        Random random = new Random();
        int i = random.nextInt(100);
        String str = null;
        str = String.valueOf(System.currentTimeMillis());
        if (i < 10){
            str += "0"+i;
        }
        return str += i;
    }
}
