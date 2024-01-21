package web.userDao;

import web.model.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();

    void deleteUser(User user);

    void addUser(User user);

    void changeUser(User user);
}
