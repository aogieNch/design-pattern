package org.example;

import org.example.domain.model.GiaoDichDat;
import org.example.persistence.GiaoDichDAO;
import org.example.persistence.GiaoDichDAOImp;
import org.example.persistence.GiaoDichGateWayImp;
import org.example.presentation.controller.GiaoDichController;
import org.example.presentation.view.GiaoDichView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GiaoDichGateWayImp giaoDichGateWayImp = new GiaoDichGateWayImp();
                    GiaoDichDAOImp giaoDichDAO = new GiaoDichDAOImp(giaoDichGateWayImp);
                    GiaoDichDat giaoDichDat = new GiaoDichDat(giaoDichDAO);

                    GiaoDichController giaoDichController = new GiaoDichController(giaoDichDat);
                    GiaoDichView giaoDichView = new GiaoDichView(giaoDichController);
                    giaoDichView.setVisible(true);
            }
        });
    }
}