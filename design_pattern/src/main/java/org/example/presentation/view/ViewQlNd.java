package org.example.presentation.view;

import org.example.domain.model.GiaoDichDat;
import org.example.domain.model.GiaoDichNha;
import org.example.domain.model.LoaiDat;
import org.example.domain.model.LoaiNha;
import org.example.observer.DataObserver;
import org.example.presentation.controller.GiaoDichController;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ViewQlNd extends JFrame implements DataObserver {

    private JPanel contentPane;
    private JTextField textField_NgayGD;
    private JTextField textField_DonGia;
    private JTextField textField_DienTich;
    private JTextField textField_DiaChi;
    private JTextField textField_Id;
    private JTextField textField_IDNMG;
    private JComboBox<String> comboBox_LoaiGD;
    private JComboBox<LoaiDat> comboBox_LoaiDat;
    private JComboBox<LoaiNha> comboBox_LoaiNha;
    private JTable table_DSDat;
    private JTable table_DSNha;
    private GiaoDichController controller;

    public ViewQlNd(GiaoDichController controller) {
        this.controller = controller;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 722, 450);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel label_LoaiGD = new JLabel("Loại GD");
        label_LoaiGD.setBounds(10, 11, 46, 14);
        contentPane.add(label_LoaiGD);

        JLabel label_NgayGD = new JLabel("Ngày GD");
        label_NgayGD.setBounds(172, 11, 55, 14);
        contentPane.add(label_NgayGD);

        JLabel label_DonGia = new JLabel("Đơn Giá");
        label_DonGia.setBounds(387, 11, 55, 14);
        contentPane.add(label_DonGia);

        JLabel label_DienTich = new JLabel("Diện Tích");
        label_DienTich.setBounds(560, 11, 55, 14);
        contentPane.add(label_DienTich);

        comboBox_LoaiGD = new JComboBox<>();
        comboBox_LoaiGD.addItem("Loại Đất");
        comboBox_LoaiGD.addItem("Loại Nhà");
        comboBox_LoaiGD.setBounds(66, 7, 85, 22);
        contentPane.add(comboBox_LoaiGD);

        textField_NgayGD = new JTextField();
        textField_NgayGD.setBounds(237, 8, 109, 20);
        contentPane.add(textField_NgayGD);
        textField_NgayGD.setColumns(10);

        textField_DonGia = new JTextField();
        textField_DonGia.setColumns(10);
        textField_DonGia.setBounds(439, 8, 86, 20);
        contentPane.add(textField_DonGia);

        textField_DienTich = new JTextField();
        textField_DienTich.setColumns(10);
        textField_DienTich.setBounds(625, 8, 71, 20);
        contentPane.add(textField_DienTich);


        JLabel label_LoaiDat = new JLabel("Loại Đất");
        label_LoaiDat.setBounds(10, 39, 57, 14);
        contentPane.add(label_LoaiDat);

        JLabel label_Id = new JLabel("ID");
        label_Id.setBounds(150, 39, 40, 14);
        contentPane.add(label_Id);

        JLabel label_LoaiNha = new JLabel("Loại Nhà");
        label_LoaiNha.setBounds(245, 39, 56, 14);
        contentPane.add(label_LoaiNha);

        Label label_IDNMG = new Label("IDNMG");
        label_IDNMG.setBounds(415, 35, 40, 22);
        contentPane.add(label_IDNMG);

        JLabel label_DiaChi = new JLabel("Địa Chỉ");
        label_DiaChi.setBounds(536, 36, 46, 14);
        contentPane.add(label_DiaChi);

        comboBox_LoaiDat = new JComboBox<>(LoaiDat.values());
        comboBox_LoaiDat.setBounds(66, 36, 52, 22);
        contentPane.add(comboBox_LoaiDat);

        textField_Id = new JTextField();
        textField_Id.setBounds(167, 38, 40, 20);
        contentPane.add(textField_Id);

        comboBox_LoaiNha = new JComboBox<>(LoaiNha.values());
        comboBox_LoaiNha.setBounds(300, 35, 93, 22);
        contentPane.add(comboBox_LoaiNha);

        textField_IDNMG = new JTextField();
        textField_IDNMG.setBounds(460, 35, 38, 22);
        contentPane.add(textField_IDNMG);

        textField_DiaChi = new JTextField();
        textField_DiaChi.setColumns(10);
        textField_DiaChi.setBounds(592, 33, 92, 20);
        contentPane.add(textField_DiaChi);

        JSeparator separator = new JSeparator();
        separator.setBounds(10, 63, 696, 8);
        contentPane.add(separator);

        // table DS Đất
        JLabel label_DSGDDat = new JLabel("Danh sách giao dịch đất");
        label_DSGDDat.setBounds(10, 77, 150, 14);
        contentPane.add(label_DSGDDat);

        table_DSDat = new JTable();
        table_DSDat.setSurrendersFocusOnKeystroke(true);
        table_DSDat.setModel(new DefaultTableModel(
                new Object[][] {
                        { null, null, null, null, null, null},
                },
                new String[] {
                        "MaGD", "NgayGD", "DonGia", "DienTich", "LoaiDat", "ThanhTien"
                }));
        table_DSDat.getSelectionModel().addListSelectionListener(e -> {
            int selectedRow = table_DSDat.getSelectedRow();
            if (selectedRow >= 0) {
                DefaultTableModel dtmDat = (DefaultTableModel) table_DSDat.getModel();
                int maGiaoDich = (int) dtmDat.getValueAt(selectedRow, 0);
                LocalDate ngayGiaoDich = (LocalDate) dtmDat.getValueAt(selectedRow, 1);
                double donGia = (double) dtmDat.getValueAt(selectedRow, 2);
                double dienTich = (double) dtmDat.getValueAt(selectedRow, 3);
                LoaiDat loaiDat = (LoaiDat) dtmDat.getValueAt(selectedRow, 4);

                // Update the text fields with the selected row data
                textField_Id.setText(Integer.toString(maGiaoDich));
                textField_NgayGD.setText(ngayGiaoDich.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
                textField_DonGia.setText(Double.toString(donGia));
                textField_DienTich.setText(Double.toString(dienTich));
                comboBox_LoaiDat.setSelectedItem(loaiDat);

                // Disable/Enable appropriate fields based on the selected Loai giao dich
                textField_DiaChi.setEnabled(false);
                label_LoaiNha.setEnabled(false);
                comboBox_LoaiNha.setEnabled(false);
                label_LoaiDat.setEnabled(true);
                comboBox_LoaiDat.setEnabled(true);
                comboBox_LoaiGD.setSelectedIndex(0);
            }
        });

        JScrollPane scrollPane = new JScrollPane(table_DSDat);
        scrollPane.setBounds(10, 93, 696, 115);
        contentPane.add(scrollPane);

        //table DS Nhà
        JLabel label_DSGDNha = new JLabel("Danh sách giao dịch nhà");
        label_DSGDNha.setBounds(10, 220, 150, 14);
        contentPane.add(label_DSGDNha);

        JScrollPane scrollPane_1 = new JScrollPane((Component) null);
        scrollPane_1.setBounds(10, 235, 696, 108);
        contentPane.add(scrollPane_1);

        table_DSNha = new JTable();
        table_DSNha.setModel(new DefaultTableModel(
                new Object[][] {
                        { null, null, null, null, null, null, null, null },
                },
                new String[] {
                        "MaGD", "NgayGD", "DonGia", "LoaiNha", "DiaChi", "DienTich", "ThanhTien"
                }));
        table_DSNha.getSelectionModel().addListSelectionListener(e -> {
            int selectedRow = table_DSNha.getSelectedRow();
            if (selectedRow >= 0) {
                DefaultTableModel dtmNha = (DefaultTableModel) table_DSNha.getModel();
                int maGiaoDich = (int) dtmNha.getValueAt(selectedRow, 0);
                LocalDate ngayGiaoDich = (LocalDate) dtmNha.getValueAt(selectedRow, 1);
                double donGia = (double) dtmNha.getValueAt(selectedRow, 2);
                LoaiNha loaiNha = (LoaiNha) dtmNha.getValueAt(selectedRow, 3);
                String diaChi = (String) dtmNha.getValueAt(selectedRow, 4);
                double dienTich = (double) dtmNha.getValueAt(selectedRow, 5);

                // Update the text fields with the selected row data
                textField_Id.setText(Integer.toString(maGiaoDich));
                textField_NgayGD.setText(ngayGiaoDich.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
                textField_DonGia.setText(Double.toString(donGia));
                textField_DienTich.setText(Double.toString(dienTich));
                comboBox_LoaiNha.setSelectedItem(loaiNha);
                textField_DiaChi.setText(diaChi);

                // Disable/Enable appropriate fields based on the selected Loai giao dich
                textField_DiaChi.setEnabled(true);
                label_LoaiNha.setEnabled(true);
                comboBox_LoaiNha.setEnabled(true);
                label_LoaiDat.setEnabled(false);
                comboBox_LoaiDat.setEnabled(false);
                comboBox_LoaiGD.setSelectedIndex(1);
            }
        });
        table_DSNha.setSurrendersFocusOnKeystroke(true);
        scrollPane_1.setViewportView(table_DSNha);

        // các nút sự kiện
        JButton btn_Them = new JButton("Thêm");
        btn_Them.setBounds(20, 365, 71, 23);
        contentPane.add(btn_Them);
        // xử lí nút thêm giao dịch
        btn_Them.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ("Loại Đất".equals(comboBox_LoaiGD.getSelectedItem())) {
                    addGiaoDichDat();
                } else {
                    addGiaoDichNha();
                }
            }
        });

        JButton btn_Sua = new JButton("Cập nhật");
        btn_Sua.setBounds(100, 365, 92, 23);
        contentPane.add(btn_Sua);
        btn_Sua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ("Loại Đất".equals(comboBox_LoaiGD.getSelectedItem())) {
                    updateGiaoDichDat();
                } else {
//                    updateGiaoDichNha();
                }
            }
        });

        JButton btn_Xoa = new JButton("Xóa");
        btn_Xoa.setBounds(200, 365, 62, 23);
        contentPane.add(btn_Xoa);

        JButton btn_TimKiem = new JButton("Tìm Kiếm");
        btn_TimKiem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btn_TimKiem.setBounds(283, 365, 100, 23);
        contentPane.add(btn_TimKiem);

        JButton btn_TinhTB = new JButton("Tính trung bình");
        btn_TinhTB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateAvgGiaoDich();
            }
        });
        btn_TinhTB.setBounds(560, 365, 136, 23);
        contentPane.add(btn_TinhTB);

        JButton btn_TinhTong = new JButton("Tính tổng số lượng");
        btn_TinhTong.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                amountGiaoDich();
            }
        });
        btn_TinhTong.setBounds(405, 365, 145, 23);
        contentPane.add(btn_TinhTong);

        //xử lí ẩn hiện
        comboBox_LoaiGD.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if ("Loại Đất".equals(comboBox_LoaiGD.getSelectedItem())) {
                    textField_DiaChi.setEnabled(false);
                    label_LoaiNha.setEnabled(false);
                    comboBox_LoaiNha.setEnabled(false);

                } else {
                    textField_DiaChi.setEnabled(true);
                    label_LoaiNha.setEnabled(true);
                    comboBox_LoaiNha.setEnabled(true);
                }
            }
        });

        comboBox_LoaiGD.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if ("Loại Nhà".equals(comboBox_LoaiGD.getSelectedItem())) {
                    label_LoaiDat.setEnabled(false);
                    comboBox_LoaiDat.setEnabled(false);

                } else {
                    textField_DiaChi.setEnabled(true);
                    label_LoaiDat.setEnabled(true);
                    comboBox_LoaiDat.setEnabled(true);
                }
            }
        });

        loadData();
        this.setVisible(true);
        loadData();
        setLocationRelativeTo(null);
    }

    private void addGiaoDichDat() {
        int maGiaoDich = Integer.parseInt(textField_Id.getText());
        LocalDate ngayGiaoDich = LocalDate.parse(textField_NgayGD.getText(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        double donGia = Double.parseDouble(textField_DonGia.getText());
        double dienTich = Double.parseDouble(textField_DienTich.getText());
        LoaiDat loaiDat = (LoaiDat) comboBox_LoaiDat.getSelectedItem();

        int maNguoiMoGioi;
        String idNMGText = textField_IDNMG.getText();

        if (idNMGText.isEmpty()) {
            // Show an error message if the maNguoiMoGioi text field is empty
            JOptionPane.showMessageDialog(this, "Mã người mô giới không được để trống!");
            return;
        } else {
            try {
                // Try to parse the input as an integer
                maNguoiMoGioi = Integer.parseInt(idNMGText);
            } catch (NumberFormatException e) {
                // Show an error message if the input is not a valid integer
                JOptionPane.showMessageDialog(this, "Mã người mô giới phải là số nguyên!");
                return;
            }
        }

        try {
            // Add the GiaoDichDat data using the controller
            controller.addGiaoDichDat(new GiaoDichDat(maGiaoDich, ngayGiaoDich, donGia, dienTich, maNguoiMoGioi, loaiDat));

            // Show a success message if the data is added successfully
            JOptionPane.showMessageDialog(this, "Thêm giao dịch đất thành công!");

            // Clear the fields after adding the GiaoDichDat
            textField_Id.setText("");
            textField_NgayGD.setText("");
            textField_DonGia.setText("");
            textField_DienTich.setText("");
            comboBox_LoaiDat.setSelectedIndex(0);
            textField_IDNMG.setText("");
        } catch (Exception ex) {
            // Show an error message if the data could not be added
            JOptionPane.showMessageDialog(this, "Không thể thêm giao dịch đất. Vui lòng thử lại!");
        }
    }
    private void addGiaoDichNha() {
        int maGiaoDich = Integer.parseInt(textField_Id.getText());
        LocalDate ngayGiaoDich = LocalDate.parse(textField_NgayGD.getText(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        double donGia = Double.parseDouble(textField_DonGia.getText());
        double dienTich = Double.parseDouble(textField_DienTich.getText());
        LoaiNha loaiNha = (LoaiNha) comboBox_LoaiNha.getSelectedItem();
        String diaChi = textField_DiaChi.getText();

        int maNguoiMoGioi;
        String idNMGText = textField_IDNMG.getText();

        if (idNMGText.isEmpty()) {
            // Show an error message if the maNguoiMoGioi text field is empty
            JOptionPane.showMessageDialog(this, "Mã người mô giới không được để trống!");
            return;
        } else {
            try {
                // Try to parse the input as an integer
                maNguoiMoGioi = Integer.parseInt(idNMGText);
            } catch (NumberFormatException e) {
                // Show an error message if the input is not a valid integer
                JOptionPane.showMessageDialog(this, "Mã người mô giới phải là số nguyên!");
                return;
            }
        }

        try {
            controller.addGiaoDichNha(new GiaoDichNha(maGiaoDich, ngayGiaoDich, donGia, dienTich, maNguoiMoGioi, diaChi, loaiNha));

            JOptionPane.showMessageDialog(this, "Thêm giao dịch nhà thành công!");

            // Clear the fields after adding the GiaoDichNha
            textField_Id.setText("");
            textField_NgayGD.setText("");
            textField_DonGia.setText("");
            textField_DienTich.setText("");
            comboBox_LoaiNha.setSelectedIndex(0);
            textField_DiaChi.setText("");
            textField_IDNMG.setText("");
        } catch (Exception ex) {
            // Show an error message if the data could not be added
            JOptionPane.showMessageDialog(this, "Không thể thêm giao dịch nhà. Vui lòng thử lại!");
        }
    }

    //UpdateGiaoDich
    public void updateGiaoDichDat() {
        int maGiaoDich = Integer.parseInt(textField_Id.getText());
        LocalDate ngayGiaoDich = LocalDate.parse(textField_NgayGD.getText(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        double donGia = Double.parseDouble(textField_DonGia.getText());
        double dienTich = Double.parseDouble(textField_DienTich.getText());
        LoaiDat loaiDat = (LoaiDat) comboBox_LoaiDat.getSelectedItem();
        int maNguoiMoGioi;
        String idNMGText = textField_IDNMG.getText();

        if (idNMGText.isEmpty()) {
            // Show an error message if the maNguoiMoGioi text field is empty
            JOptionPane.showMessageDialog(this, "Mã người mô giới không được để trống!");
            return;
        } else {
            try {
                // Try to parse the input as an integer
                maNguoiMoGioi = Integer.parseInt(idNMGText);
            } catch (NumberFormatException e) {
                // Show an error message if the input is not a valid integer
                JOptionPane.showMessageDialog(this, "Mã người mô giới phải là số nguyên!");
                return;
            }
        }

        try {
            // Update the GiaoDichDat data using the controller
            controller.updateGiaoDichDat(new GiaoDichDat(maGiaoDich, ngayGiaoDich, donGia, dienTich, maNguoiMoGioi, loaiDat));

            // Show a success message if the data is updated successfully
            JOptionPane.showMessageDialog(this, "Cập nhật giao dịch đất thành công!");

            // Clear the fields after updating the GiaoDichDat
            textField_Id.setText("");
            textField_NgayGD.setText("");
            textField_DonGia.setText("");
            textField_DienTich.setText("");
            comboBox_LoaiDat.setSelectedIndex(0);
            textField_IDNMG.setText("");
        } catch (Exception ex) {
            // Show an error message if the data could not be updated
            JOptionPane.showMessageDialog(this, "Không thể cập nhật giao dịch đất. Vui lòng thử lại!");
        }
    }

    private void updateTableDatData(List<GiaoDichDat> giaoDichList) {
        DefaultTableModel dtmDat = (DefaultTableModel) table_DSDat.getModel();

        dtmDat.setRowCount(0); // Clear the existing data in the table

        for (GiaoDichDat giaoDich : giaoDichList) {
            Object[] rowData = {
                    giaoDich.getMaGiaoDich(),
                    giaoDich.getNgayGiaoDich(),
                    giaoDich.getDonGia(),
                    giaoDich.getDienTich(),
                    giaoDich.getLoaiDat(),
                    giaoDich.getThanhTien()
            };
            dtmDat.addRow(rowData); // Add each row of data to the table
        }
    }
    private void updateTableNhaData(List<GiaoDichNha> giaoDichList) {
        DefaultTableModel dtmNha = (DefaultTableModel) table_DSNha.getModel();

        dtmNha.setRowCount(0); // Clear the existing data in the table

        for (GiaoDichNha giaoDich : giaoDichList) {
            Object[] rowData = {
                    giaoDich.getMaGiaoDich(),
                    giaoDich.getNgayGiaoDich(),
                    giaoDich.getDonGia(),
                    giaoDich.getLoaiNha(),
                    giaoDich.getDiaChi(),
                    giaoDich.getDienTich(),
                    giaoDich.getThanhTien()
            };
            dtmNha.addRow(rowData); // Add each row of data to the table
        }
    }
    private void loadData() {
        // Call the service to get all GiaoDichDat objects from the database
        List<GiaoDichDat> giaoDichDatList = controller.getGiaoDichDatByUserId(controller.getMaNguoiGiaoDich());
        List<GiaoDichNha> giaoDichNhaList = controller.getGiaoDichNhaByUserId(controller.getMaNguoiGiaoDich());

        // Update the table with the retrieved data
        updateTableDatData(giaoDichDatList);
        updateTableNhaData(giaoDichNhaList);

        comboBox_LoaiGD.setSelectedIndex(0);
    }

    @Override
    public void onDataChanged() {
        loadData(); // Update the view when data changes
    }

    private void calculateAvgGiaoDich() {
        int maNguoiGiaoDich = Integer.parseInt(textField_IDNMG.getText());
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
        int maNguoiGiaoDich = Integer.parseInt(textField_IDNMG.getText());
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

