package www.zh.dao;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import www.zh.common.Product;
import www.zh.source.DruidDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ProDaoImpl implements ProDao{

    private QueryRunner qr;
    private DruidDataSource dds = DruidDataSource.getDataSource();

    public ProDaoImpl(){
        //构造器初始化QueryRunner对象
        qr = new QueryRunner();
    }
    @Override
    public void addProduct(Product pd) {
        Connection con = dds.getConnection();
        String sql = "INSERT INTO product VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            qr.update(con,sql,pd.getPro_id(),pd.getPro_name(),pd.getPro_price(),pd.getPro_image(),pd.getPro_des(),pd.getPro_stock(),pd.getPro_date(),pd.getPro_category_id(),pd.getPro_factory());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DbUtils.close(con);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
