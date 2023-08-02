package org.example.presentation.view;

import org.example.domain.model.service.GiaoDichService;
import org.example.domain.model.service.GiaoDichServiceImp;
import org.example.persistence.GiaoDichDAO;
import org.example.persistence.GiaoDichDAOImp;
import org.example.persistence.GiaoDichGateWay;
import org.example.persistence.GiaoDichGateWayImp;
import org.example.presentation.controller.GiaoDichController;
import org.example.presentation.controller.UserController;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JButton;

public class UserView extends JFrame {

    private JPanel contentPane;
    private JTextField textField_TenDangNhap;
    private JTextField textField_MkDangNhap;
    private UserController controller;

    public UserView(UserController controller) {
        this.controller = controller;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel label_DangNhap = new JLabel("Chào mừng bạn đến với phần mềm quản lí nhà đất");
        label_DangNhap.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
        label_DangNhap.setHorizontalAlignment(SwingConstants.CENTER);
        label_DangNhap.setBounds(0, 11, 424, 62);
        contentPane.add(label_DangNhap);

        JLabel label_DangNhap2 = new JLabel("Vui lòng đăng nhập tại đây");

        label_DangNhap2.setFont(new Font("Times New Roman", Font.ITALIC, 12));

        label_DangNhap2.setBounds(109, 100, 161, 14);
        contentPane.add(label_DangNhap2);

        JLabel label_TenDangNhap = new JLabel("Tên đăng nhập");
        label_TenDangNhap.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        label_TenDangNhap.setBounds(52, 132, 82, 14);
        contentPane.add(label_TenDangNhap);

        textField_TenDangNhap = new JTextField();
        textField_TenDangNhap.setBounds(144, 129, 167, 20);
        contentPane.add(textField_TenDangNhap);
        textField_TenDangNhap.setColumns(10);

        JLabel label_MkDangNhap_1 = new JLabel("Mật khẩu");
        label_MkDangNhap_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        label_MkDangNhap_1.setBounds(52, 176, 82, 14);
        contentPane.add(label_MkDangNhap_1);

        textField_MkDangNhap = new JTextField();
        textField_MkDangNhap.setColumns(10);
        textField_MkDangNhap.setBounds(144, 173, 167, 20);
        contentPane.add(textField_MkDangNhap);

        JButton btn_DangNhap = new JButton("Đăng nhập");
        btn_DangNhap.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        btn_DangNhap.setBounds(164, 214, 105, 23);
        contentPane.add(btn_DangNhap);

        btn_DangNhap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });
    }

    private void login() {
        String username = textField_TenDangNhap.getText();
        String password = textField_MkDangNhap.getText();
        controller.checkLogin(username, password);

        if (controller.checkLogin(username, password)) {
            this.setVisible(false);
            GiaoDichGateWay giaoDichGateWayImp = new GiaoDichGateWayImp();
            GiaoDichDAO giaoDichDAO = new GiaoDichDAOImp(giaoDichGateWayImp);

            GiaoDichService giaoDichService = new GiaoDichServiceImp(giaoDichDAO);

            GiaoDichController controller = new GiaoDichController(giaoDichService);
            GiaoDichView view = new GiaoDichView(controller);
            view.setVisible(true);
        } else {
            System.out.println("Sai tên đăng nhập hoặc mật khẩu");
        }
    }
}

