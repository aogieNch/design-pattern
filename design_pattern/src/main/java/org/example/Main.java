package org.example;

import org.example.domain.model.GiaoDichDat;
import org.example.domain.model.service.GiaoDichService;
import org.example.domain.model.service.GiaoDichServiceImp;
import org.example.persistence.GiaoDichDAO;
import org.example.persistence.GiaoDichDAOImp;
import org.example.persistence.GiaoDichGateWay;
import org.example.persistence.GiaoDichGateWayImp;
import org.example.presentation.controller.GiaoDichController;
import org.example.presentation.view.GiaoDichView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GiaoDichGateWay giaoDichGateWayImp = new GiaoDichGateWayImp();
                GiaoDichDAO giaoDichDAO = new GiaoDichDAOImp(giaoDichGateWayImp);

                GiaoDichService giaoDichService = new GiaoDichServiceImp(giaoDichDAO);

                GiaoDichController controller = new GiaoDichController(giaoDichService);
                GiaoDichView view = new GiaoDichView(controller);
                view.setVisible(true);
            }
        });
    }
}