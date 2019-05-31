package www.zh.dao;

import www.zh.common.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUser();

    void up(User user);

    void del(Integer id);


}
