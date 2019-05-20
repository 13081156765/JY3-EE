package www.zh.dao;

import www.zh.com.User;

import javax.jws.soap.SOAPBinding;

public interface Test2Dao {

    //注册
    void regsiter (String username,String password);

    //登录
    User login(User user);
}
