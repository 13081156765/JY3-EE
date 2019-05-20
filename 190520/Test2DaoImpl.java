package www.zh.dao;

import www.zh.com.User;
import www.zh.utils.DButils;

import java.sql.*;

public class Test2DaoImpl implements Test2Dao {

    //注册实现类
    public void regsiter (String username,String password){
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DButils.getConnection();
            String sql = "INSERT INTO test (username,password) VALUES(?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DButils.closePreparedStatement(ps);
            DButils.closeConnection(con);

        }

    }

    //登录实现类
    public User login(User user){
        Connection con = DButils.getConnection();
        String sql = "SELECT username,password FROM test WHERE username = ? AND password = ?";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            rs = ps.executeQuery();
            if (rs.next()){
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DButils.closeResultSet(rs);
            DButils.closePreparedStatement(ps);
            DButils.closeConnection(con);
        }
        return null;
    }

}
