package org.example.presentation.view;
import org.example.domain.model.GiaoDichDat;
import org.example.domain.model.LoaiDat;
import org.example.presentation.controller.GiaoDichController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class GiaoDichView extends JFrame {

    private final JTextField maGiaoDichField;
    private final JTextField ngayGiaoDichField;
    private final JTextField donGiaField;
    private final JTextField dienTichField;
    private final JComboBox<LoaiDat> loaiDatComboBox;
    private final JTextField maNguoiMoGioiField;
    private JButton addButton, calculateButton, amountButton;

    //Table GiaoDich
    private List<GiaoDichDat> giaoDichDatList;
//    private DefaultTableModel giaoDichDatTableModel;
//    private JTable giaoDichDatTable;

    private GiaoDichController controller;

    public GiaoDichView(GiaoDichController controller) {
        this.controller = controller;

        setTitle("Test Add GiaoDichDat");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);
        setLocationRelativeTo(null);

        maGiaoDichField = new JTextField(10);
        ngayGiaoDichField = new JTextField(10);
        donGiaField = new JTextField(10);
        dienTichField = new JTextField(10);
        loaiDatComboBox = new JComboBox<>(LoaiDat.values());
        maNguoiMoGioiField = new JTextField(10);

        //Table
        giaoDichDatList = new ArrayList<>();
        controller.getGiaoDichDatByUserId(2).forEach(giaoDichDatList::add);
        System.out.println("GiaoDichDatList: " + giaoDichDatList);

        //Button
        addButton = new JButton("Add GiaoDichDat");
        calculateButton = new JButton("Calculate");
        amountButton = new JButton("Amount");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addGiaoDichDat();
            }
        });

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateAvgGiaoDich();
            }
        });

        amountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                amountGiaoDich();
            }
        });

        //Form
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

        //Add to contentPane
        contentPane.add(formPanel, BorderLayout.CENTER);
        contentPane.add(addButton, BorderLayout.SOUTH);
        contentPane.add(calculateButton, BorderLayout.NORTH);
        contentPane.add(amountButton, BorderLayout.EAST);

        setContentPane(contentPane);
    }

//    //Fetch all GiaoDichDat from the database and display them in the table
//    private void fetchGiaoDichDat() {
//        giaoDichDatList = controller.getAllGiaoDichDat();
//
//        // Create a table model and set the column names
//        giaoDichDatTableModel = new DefaultTableModel();
//        giaoDichDatTableModel.setColumnIdentifiers(new String[]{
//                "Ma Giao Dich",
//                "Ngay Giao Dich",
//                "Don Gia",
//                "Dien Tich",
//                "Loai Dat"
//        });
//
//        // Add the GiaoDichDat objects to the table model as rows
//        for (GiaoDichDat giaoDichDat : giaoDichDatList) {
//            giaoDichDatTableModel.addRow(new Object[]{
//                    giaoDichDat.getMaGiaoDich(),
//                    giaoDichDat.getNgayGiaoDich(),
//                    giaoDichDat.getDonGia(),
//                    giaoDichDat.getDienTich(),
//                    giaoDichDat.getLoaiDat()
//            });
//        }
//
//        // Set the table model for the table
//        giaoDichDatTable.setModel(giaoDichDatTableModel);
//    }

    private void addGiaoDichDat() {
        int maGiaoDich = Integer.parseInt(maGiaoDichField.getText());
        LocalDate ngayGiaoDich = LocalDate.parse(ngayGiaoDichField.getText(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        double donGia = Double.parseDouble(donGiaField.getText());
        double dienTich = Double.parseDouble(dienTichField.getText());
        int maNguoiMoGioi = Integer.parseInt(maNguoiMoGioiField.getText());
        LoaiDat loaiDat = (LoaiDat) loaiDatComboBox.getSelectedItem();

        controller.addGiaoDichDat(new GiaoDichDat(maGiaoDich, ngayGiaoDich, donGia, dienTich, maNguoiMoGioi, loaiDat));

        JOptionPane.showMessageDialog(this, "GiaoDichDat added successfully!");

        // Clear the fields after adding the GiaoDichDat
        maGiaoDichField.setText("");
        ngayGiaoDichField.setText("");
        donGiaField.setText("");
        dienTichField.setText("");
        loaiDatComboBox.setSelectedIndex(0);
        maNguoiMoGioiField.setText("");
    }

    private void calculateAvgGiaoDich() {
        int maNguoiGiaoDich = Integer.parseInt(maNguoiMoGioiField.getText());
        float resultDat = controller.calculateGiaoDichDat(maNguoiGiaoDich);
        float resultNha = controller.calculateGiaoDichNha(maNguoiGiaoDich);
        float resultAll = controller.calculateGiaoDich(maNguoiGiaoDich);

        // Format the result as a decimal number with two decimal places
        String formattedResultDat = String.format("%,.0f tr", resultDat);
        String formattedResultNha = String.format("%,.0f tr", resultNha);
        String formattedResult = String.format("%,.0f tr", resultAll);

        // Display the formatted result in a JOptionPane message dialog
        String title = "Tổng tiền giao dịch của người mô giới có mã " + maNguoiGiaoDich + " là: ";
        String dat = "Giao dịch đất: " + formattedResultDat;
        String nha = "Giao dịch nhà: " + formattedResultNha;
        String all = "Tổng giao dịch: " + formattedResult;
        JOptionPane.showMessageDialog(this,title + "\n" + dat + "\n" + nha + "\n" + all);
    }

    private void amountGiaoDich(){
        int maNguoiGiaoDich = Integer.parseInt(maNguoiMoGioiField.getText());
        int resultDat = controller.amountGiaoDichDat(maNguoiGiaoDich);
        int resultNha = controller.amountGiaoDichNha(maNguoiGiaoDich);
        int resultAll = controller.amountGiaoDich(maNguoiGiaoDich);

        String title = "Số lượng giao dịch của người mô giới có mã " + maNguoiGiaoDich + " là: ";
        String dat = "Giao dịch đất: " + resultDat;
        String nha = "Giao dịch nhà: " + resultNha;
        String all = "Tổng giao dịch: " + resultAll;
        JOptionPane.showMessageDialog(this,title + "\n" + dat + "\n" + nha + "\n" + all);
    }
}