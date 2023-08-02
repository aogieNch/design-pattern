package org.example.domain.model.service.user;

import org.example.persistence.login.UserDAO;

public class UserServiceImp implements UserService {
    private final UserDAO userDAO;

    public UserServiceImp(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    @Override
    public boolean checkLogin(String username, String password) {
        return userDAO.login(username, password);
    }
}
