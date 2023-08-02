package org.example.presentation.controller;

import org.example.domain.model.service.user.UserService;

public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public boolean checkLogin(String username, String password) {
        return userService.checkLogin(username, password);
    }

}
