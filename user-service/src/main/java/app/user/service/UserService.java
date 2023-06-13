package app.user.service;

import app.user.model.User;

public interface UserService {
    void addNewUser(User user);
    User findById(String id);
    void delete(User user);
    void updateUser(User user);
    void addNewUserWithContents(User user);
}


