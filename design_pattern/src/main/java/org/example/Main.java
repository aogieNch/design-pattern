package org.example;

import org.example.domain.model.service.user.UserService;
import org.example.domain.model.service.user.UserServiceImp;

import org.example.persistence.login.UserDAO;
import org.example.persistence.login.UserDAOImp;
import org.example.persistence.login.UserGateWay;
import org.example.persistence.login.UserGateWayImp;
import org.example.presentation.controller.UserController;
import org.example.presentation.view.UserView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                UserGateWay userGateWay = new UserGateWayImp();
                UserDAO userDAO = new UserDAOImp(userGateWay);
                UserService userService = new UserServiceImp(userDAO);
                UserController userController = new UserController(userService);
                UserView userView = new UserView(userController);
                userView.setVisible(true);
            }
        });
    }
}