package www.zh.source;


import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

/*
* 配置连接池
*/
public class DruidDataSource {

    private static Properties pro = new Properties();
    private static DruidDataSource dds = null;
    private DruidDataSource(){

    }
    public static DruidDataSource getDataSource(){
        if (null == dds){
            dds = new DruidDataSource();
        }
        return dds;
    }
    //拿连接
    public Connection getConnection(){
        try {
            pro.load(DruidDataSource.class.getResourceAsStream("/mysql.properties"));
            DataSource ds = DruidDataSourceFactory.createDataSource(pro);
            Connection con = ds.getConnection();
            return con;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    //测试拿没拿到链接
    public static void main(String[] args) {
        DruidDataSource ds = DruidDataSource.getDataSource();
        Connection con = ds.getConnection();
        System.out.print(con);
    }



}
