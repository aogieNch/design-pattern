package org.example.presentation.view;

import org.example.domain.model.service.GiaoDichService;
import org.example.domain.model.service.GiaoDichServiceImp;
import org.example.persistence.GiaoDichDAO;
import org.example.persistence.GiaoDichDAOImp;
import org.example.persistence.GiaoDichGateWay;
import org.example.persistence.GiaoDichGateWayImp;
import org.example.presentation.controller.GiaoDichController;
import org.example.presentation.controller.UserController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserView extends JFrame {

    private JPanel contentPane;
    private final JTextField textField_TenDangNhap;
    private final JPasswordField textField_MkDangNhap;
    private final UserController controller;

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

        textField_MkDangNhap = new JPasswordField();
        textField_MkDangNhap.setColumns(10);
        textField_MkDangNhap.setBounds(144, 173, 167, 20);
        contentPane.add(textField_MkDangNhap);

        JButton btn_DangNhap = new JButton("Đăng nhập");
        btn_DangNhap.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        btn_DangNhap.setBounds(164, 214, 105, 23);
        contentPane.add(btn_DangNhap);

        ActionListener dangNhapListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        };

        // Add the ActionListener to the "Đăng Nhập" button
        btn_DangNhap.addActionListener(dangNhapListener);

        // Add an action listener to the root pane of the JFrame to handle the Enter key
        getRootPane().setDefaultButton(btn_DangNhap);
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
        getRootPane().getActionMap().put("enter", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dangNhapListener.actionPerformed(e);
            }
        });
        setLocationRelativeTo(null);
    }

    // Modify login() method to retrieve the user ID and pass it to loadData()
    private void login() {
        String username = textField_TenDangNhap.getText();
        char[] passwordCharArray = textField_MkDangNhap.getPassword();
        String password = new String(passwordCharArray); // Convert char array to String

        // Hash the password using a hashing algorithm (e.g., SHA-256)
        String hashedPassword = hashPassword(password);

        boolean loginSuccess = controller.checkLogin(username, hashedPassword);
        if (loginSuccess) {
            int userId = controller.getMaNguoiMoGioi(username); // Replace this with the correct method to get the user ID by username
            this.setVisible(false);
            loadData(userId);
        } else {
            JOptionPane.showMessageDialog(this, "Sai tên đăng nhập hoặc mật khẩu");
        }
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());

            // Convert the byte array to a hexadecimal representation
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Modify loadData() method to accept the userId as a parameter
    private void loadData(int userId) {
        GiaoDichGateWay giaoDichGateWayImp = new GiaoDichGateWayImp();
        GiaoDichDAO giaoDichDAO = new GiaoDichDAOImp(giaoDichGateWayImp);
        GiaoDichService giaoDichService = new GiaoDichServiceImp(giaoDichDAO);
        GiaoDichController giaoDichController = new GiaoDichController(giaoDichService, userId);

        ViewQlNd view = new ViewQlNd(giaoDichController);

        giaoDichService.registerObserver(view);

        view.setVisible(true);
    }

}

