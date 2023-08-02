package org.example.domain.command;

import org.example.persistence.GiaoDichDAO;
import org.example.persistence.login.UserDAO;

public class Login implements Command{
    private final UserDAO userDAO;
    private final String username;
    private final String password;

    public Login(UserDAO userDAO, String username, String password) {
        this.userDAO = userDAO;
        this.username = username;
        this.password = password;
    }

    @Override
    public void execute() {
        userDAO.login(username, password);
    }
}
