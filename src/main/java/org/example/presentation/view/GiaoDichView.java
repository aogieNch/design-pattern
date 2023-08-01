package org.example.presentation.view;
import org.example.domain.model.GiaoDichDat;
import org.example.domain.model.LoaiDat;
import org.example.presentation.controller.GiaoDichController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GiaoDichView extends JFrame {

    private JTextField maGiaoDichField;
    private JTextField ngayGiaoDichField;
    private JTextField donGiaField;
    private JTextField dienTichField;
    private JComboBox<LoaiDat> loaiDatComboBox;
    private JTextField maNguoiMoGioiField;
    private JButton addButton;

    private GiaoDichController controller;

    public GiaoDichView() {
        setTitle("Test Add GiaoDichDat");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        controller = new GiaoDichController();

        maGiaoDichField = new JTextField(10);
        ngayGiaoDichField = new JTextField(10);
        donGiaField = new JTextField(10);
        dienTichField = new JTextField(10);
        loaiDatComboBox = new JComboBox<>(LoaiDat.values());
        maNguoiMoGioiField = new JTextField(10);
        addButton = new JButton("Add GiaoDichDat");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addGiaoDichDat();
            }
        });

        JPanel contentPane = new JPanel(new BorderLayout());
        JPanel formPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        formPanel.add(new JLabel("Ma Giao Dich:"));
        formPanel.add(maGiaoDichField);
        formPanel.add(new JLabel("Ngay Giao Dich (yyyy-MM-dd):"));
        formPanel.add(ngayGiaoDichField);
        formPanel.add(new JLabel("Don Gia:"));
        formPanel.add(donGiaField);
        formPanel.add(new JLabel("Dien Tich:"));
        formPanel.add(dienTichField);
        formPanel.add(new JLabel("Loai Dat:"));
        formPanel.add(loaiDatComboBox);
        formPanel.add(new JLabel("Ma Nguoi Mo Gioi:"));
        formPanel.add(maNguoiMoGioiField);

        contentPane.add(formPanel, BorderLayout.CENTER);
        contentPane.add(addButton, BorderLayout.SOUTH);

        setContentPane(contentPane);
    }

    private void addGiaoDichDat() {
        int maGiaoDich = Integer.parseInt(maGiaoDichField.getText());
        LocalDate ngayGiaoDich = LocalDate.parse(ngayGiaoDichField.getText(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        double donGia = Double.parseDouble(donGiaField.getText());
        double dienTich = Double.parseDouble(dienTichField.getText());
        int maNguoiMoGioi = Integer.parseInt(maNguoiMoGioiField.getText());
        LoaiDat loaiDat = (LoaiDat) loaiDatComboBox.getSelectedItem();

        GiaoDichDat giaoDichDat = new GiaoDichDat(maGiaoDich, ngayGiaoDich, donGia, dienTich, maNguoiMoGioi, loaiDat);
        controller.addGiaoDichDat(giaoDichDat);

        JOptionPane.showMessageDialog(this, "GiaoDichDat added successfully!");

        // Clear the fields after adding the GiaoDichDat
        maGiaoDichField.setText("");
        ngayGiaoDichField.setText("");
        donGiaField.setText("");
        dienTichField.setText("");
        loaiDatComboBox.setSelectedIndex(0);
        maNguoiMoGioiField.setText("");
    }
}
