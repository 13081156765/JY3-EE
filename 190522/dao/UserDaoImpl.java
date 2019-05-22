package www.zh.dao;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import www.zh.common.User;
import www.zh.datasource.DruidDataSource;

import javax.jws.soap.SOAPBinding;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao{

    private QueryRunner qr = null;
    private DruidDataSource dds = DruidDataSource.getDataSource();

    public UserDaoImpl(){
        //构造器初始化QueryRunner对象
        qr = new QueryRunner();
    }

    @Override
    public List<User> getAllUser() {
        String sql = "SELECT * FROM test";
        List<User> users = null;
        Connection con = dds.getConnection();
        try {
            users = qr.query(con,sql, new BeanListHandler<>(User.class));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DbUtils.close(con);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return users;
    }



    public void up(String id,String oldpassword, String password){
        String sql = "UPDATE test SET password = ? WHERE id = ?";
        Connection con = dds.getConnection();
        try {
            int result = qr.update(con,sql,"?","?");
            System.out.println(result);
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
