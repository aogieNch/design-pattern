package org.example.presentation.view;

import org.example.domain.model.GiaoDichDat;
import org.example.domain.model.GiaoDichNha;
import org.example.domain.model.LoaiDat;
import org.example.domain.model.LoaiNha;
import org.example.domain.model.service.GiaoDichService;
import org.example.domain.model.service.GiaoDichServiceImp;
import org.example.persistence.GiaoDichDAO;
import org.example.persistence.GiaoDichDAOImp;
import org.example.persistence.GiaoDichGateWay;
import org.example.persistence.GiaoDichGateWayImp;
import org.example.presentation.controller.GiaoDichController;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class ViewQlNd extends JFrame {

    private JPanel contentPane;
    private JTextField textField_NgayGD;
    private JTextField textField_DonGia;
    private JTextField textField_DienTich;
    private JTextField textField_DiaChi;
    private JTable table_DSDat;
    private JTable table_DSNha;
    private GiaoDichController controller;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GiaoDichGateWay giaoDichGateWayImp = new GiaoDichGateWayImp();
                    GiaoDichDAO giaoDichDAO = new GiaoDichDAOImp(giaoDichGateWayImp);

                    GiaoDichService giaoDichService = new GiaoDichServiceImp(giaoDichDAO);

                    GiaoDichController controller = new GiaoDichController(giaoDichService);
                    ViewQlNd frame = new ViewQlNd(controller);

                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
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

        JComboBox<String> comboBox_LoaiGD = new JComboBox<>();
        comboBox_LoaiGD.addItem("Loại Đất");
        comboBox_LoaiGD.addItem("Loại Nhà");
        comboBox_LoaiGD.setBounds(66, 7, 85, 22);

        contentPane.add(comboBox_LoaiGD);

        JLabel label_LoaiDat = new JLabel("Loại Đất");
        label_LoaiDat.setBounds(10, 39, 57, 14);
        contentPane.add(label_LoaiDat);

        JLabel label_LoaiNha = new JLabel("Loại Nhà");
        label_LoaiNha.setBounds(272, 39, 56, 14);
        contentPane.add(label_LoaiNha);

        JLabel label_DiaChi = new JLabel("Địa Chỉ");
        label_DiaChi.setBounds(536, 36, 46, 14);
        contentPane.add(label_DiaChi);

        JComboBox<LoaiDat> comboBox_LoaiDat = new JComboBox<>(LoaiDat.values());

        comboBox_LoaiDat.setBounds(66, 36, 52, 22);

        contentPane.add(comboBox_LoaiDat);

        JComboBox<LoaiNha> comboBox_LoaiNha = new JComboBox<>(LoaiNha.values());

        comboBox_LoaiNha.setBounds(338, 35, 93, 22);
        contentPane.add(comboBox_LoaiNha);

        textField_DiaChi = new JTextField();
        textField_DiaChi.setColumns(10);
        textField_DiaChi.setBounds(592, 33, 92, 20);
        contentPane.add(textField_DiaChi);

        JSeparator separator = new JSeparator();
        separator.setBounds(10, 63, 696, 8);
        contentPane.add(separator);

        JLabel label_DSGDDat = new JLabel("Danh sách giao dịch đất");
        label_DSGDDat.setBounds(10, 77, 150, 14);
        contentPane.add(label_DSGDDat);


        table_DSDat = new JTable();
        table_DSDat.setSurrendersFocusOnKeystroke(true);
        table_DSDat.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null, null, null, null, null, null, null},
                },
                new String[] {
                        "MaGD", "NgayGD", "DonGia", "DienTich", "LoaiDat", "ThanhTien"
                }
        ));

        JScrollPane scrollPane = new JScrollPane(table_DSDat);
        scrollPane.setBounds(10, 93, 696, 115);
        contentPane.add(scrollPane);

        JLabel label_DSGDNha = new JLabel("Danh sách giao dịch nhà");
        label_DSGDNha.setBounds(10, 220, 150, 14);
        contentPane.add(label_DSGDNha);

        JScrollPane scrollPane_1 = new JScrollPane((Component) null);
        scrollPane_1.setBounds(10, 235, 696, 108);
        contentPane.add(scrollPane_1);

        table_DSNha = new JTable();
        table_DSNha.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null, null, null, null, null, null, null},
                },
                new String[] {
                        "MaGD", "NgayGD", "DonGia", "LoaiNha", "DiaChi", "DienTich", "ThanhTien"
                }
        ));
        table_DSNha.setSurrendersFocusOnKeystroke(true);
        scrollPane_1.setViewportView(table_DSNha);

        JButton btn_Them = new JButton("Thêm");
        btn_Them.setBounds(20, 365, 71, 23);
        contentPane.add(btn_Them);

        JButton btn_Sua = new JButton("Cập nhật");

        btn_Sua.setBounds(100, 365, 92, 23);
        contentPane.add(btn_Sua);

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
        btn_TinhTB.setBounds(560, 365, 136, 23);
        contentPane.add(btn_TinhTB);

        JButton btn_TinhTong = new JButton("Tính tổng số lượng");
        btn_TinhTong.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btn_TinhTong.setBounds(405, 365, 145, 23);
        contentPane.add(btn_TinhTong);

        this.setVisible(true);
        loadData();
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
        List<GiaoDichDat> giaoDichDatList = controller.getGiaoDichDatByUserId(2);
        List<GiaoDichNha> giaoDichNhaList = controller.getGiaoDichNhaByUserId(2);

        // Update the table with the retrieved data
        updateTableDatData(giaoDichDatList);
        updateTableNhaData(giaoDichNhaList);
    }
}

