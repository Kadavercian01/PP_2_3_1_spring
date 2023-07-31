package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void create(User user);
    List<User> getListUsers();
    void delete(int id);
    void update(int id, User user);
    User getUser(int id);
    void save(User user);
}
