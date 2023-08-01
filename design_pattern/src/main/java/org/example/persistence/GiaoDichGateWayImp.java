package org.example.persistence;

import org.example.domain.model.GiaoDichDat;

import java.sql.*;
import java.util.List;

public class GiaoDichGateWayImp implements GiaoDichGateWay {

    private Connection connection;

    public GiaoDichGateWayImp() {
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
    public void addGiaoDichDat(GiaoDichDat giaoDichDat) {
        try {
            // Thêm dữ liệu vào bảng GiaoDich
            String insertGiaoDichSql = "INSERT INTO GiaoDich (MaGiaoDich, NgayGiaoDich, DonGia, DienTich, ThanhTien, NguoiMoGioi) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement insertGiaoDichStmt = connection.prepareStatement(insertGiaoDichSql, Statement.RETURN_GENERATED_KEYS);
            insertGiaoDichStmt.setInt(1, giaoDichDat.getMaGiaoDich());
            insertGiaoDichStmt.setDate(2, Date.valueOf(giaoDichDat.getNgayGiaoDich()));
            insertGiaoDichStmt.setDouble(3, giaoDichDat.getDonGia());
            insertGiaoDichStmt.setDouble(4, giaoDichDat.getDienTich());
            insertGiaoDichStmt.setDouble(5, giaoDichDat.thanhTien());
            insertGiaoDichStmt.setString(6, String.valueOf(giaoDichDat.getNguoiMoGioi()));
            insertGiaoDichStmt.executeUpdate();

            // Thêm dữ liệu vào bảng GiaoDichDat
            String insertGiaoDichDatSql = "INSERT INTO GiaoDichDat (MaGiaoDich, LoaiDat) VALUES (?, ?)";
            PreparedStatement insertGiaoDichDatStmt = connection.prepareStatement(insertGiaoDichDatSql);
            insertGiaoDichDatStmt.setInt(1, giaoDichDat.getMaGiaoDich());
            insertGiaoDichDatStmt.setInt(2, giaoDichDat.getLoaiDat().ordinal() + 1);
            insertGiaoDichDatStmt.executeUpdate();

            System.out.println("Thêm giao dịch đất thành công.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateGiaoDichDat(GiaoDichDat giaoDichDat) {

    }

    @Override
    public void deleteGiaoDichDat(GiaoDichDat giaoDichDat) {

    }

    @Override
    public GiaoDichDat getGiaoDichDatById(int id) {
        return null;
    }

    @Override
    public List<GiaoDichDat> getAllGiaoDichDat() {
        return null;
    }
}
