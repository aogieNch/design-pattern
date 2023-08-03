package org.example.persistence.login;

import java.sql.*;

public class UserGateWayImp implements UserGateWay {
    private Connection connection;

    public UserGateWayImp() {
        String dbUrl = "jdbc:sqlserver://localhost:1433;databaseName=quanlygiaodich;integratedSecurity=true;trustServerCertificate=true;";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(dbUrl, "nch", "123");
            System.out.println("Thanh cong");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean login(String username, String password){
        boolean isValid = false;
        try {
            String sql = "SELECT * FROM NguoiMoGioi WHERE TenDangNhap = ? AND MatKhau = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                isValid = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isValid;
    }

    @Override
    public int getMaNguoiMoGioi(String username) {
        int maNguoiMoGioi = 0;
        try {
            String sql = "SELECT MaNguoiMoGioi FROM NguoiMoGioi WHERE TenDangNhap = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                maNguoiMoGioi = rs.getInt("MaNguoiMoGioi");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return maNguoiMoGioi;
    }
}
