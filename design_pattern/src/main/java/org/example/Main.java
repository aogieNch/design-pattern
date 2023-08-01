package org.example;

import org.example.presentation.view.GiaoDichView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GiaoDichView view = new GiaoDichView();
                view.setVisible(true);
            }
        });
    }
}