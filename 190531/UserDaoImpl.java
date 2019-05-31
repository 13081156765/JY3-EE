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

    private QueryRunner qr;
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



    public void up(User user){
        String sql = "UPDATE test SET username = ?,password = ? WHERE id = ?";
        Connection con = dds.getConnection();
        try {
            qr.update(con,sql,user.getUsername(),user.getPassword(),user.getId());
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


    public void del(Integer id){
        System.out.println(id);
        String sql = "DELETE FROM test WHERE id = ?";
        Connection con = dds.getConnection();
        try {
            qr.update(con,sql,id);
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
