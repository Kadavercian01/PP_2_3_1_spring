package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void createUser(User user);
    List<User> getListUsers();
    void deleteUser(int id);
    void updateUser(User user);
    User getUser(int id);
}
