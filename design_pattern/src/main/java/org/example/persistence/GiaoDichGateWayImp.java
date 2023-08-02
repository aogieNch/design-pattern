package org.example.persistence;

import org.example.domain.model.GiaoDichDat;

import java.sql.*;

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

    //Calculate Giao dich
    @Override
    public float calculateGiaoDichDat(int maNguoiGiaoDich) {
        float result = 0.0f;
        try {
            String sql = "SELECT AVG(GiaoDich.ThanhTien) FROM GiaoDichDat INNER JOIN GiaoDich ON GiaoDich.MaGiaoDich = GiaoDichDat.MaGiaoDich WHERE GiaoDich.NguoiMoGioi = ?";
            PreparedStatement smt = connection.prepareStatement(sql);
            smt.setInt(1, maNguoiGiaoDich);
            ResultSet rs = smt.executeQuery();
            while (rs.next()) {
                result = rs.getFloat(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public float calculateGiaoDichNha(int maNguoiGiaoDich) {
        float result = 0.0f;
        try {
            String sql = "SELECT AVG(GiaoDich.ThanhTien) FROM GiaoDichNha INNER JOIN GiaoDich ON GiaoDich.MaGiaoDich = GiaoDichNha.MaGiaoDich WHERE GiaoDich.NguoiMoGioi = ?";
            PreparedStatement smt = connection.prepareStatement(sql);
            smt.setInt(1, maNguoiGiaoDich);
            ResultSet rs = smt.executeQuery();
            while (rs.next()) {
                result = rs.getFloat(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public float calculateGiaoDich(int maNguoiGiaoDich) {
        float result = 0.0f;
        try {
            String sql = "SELECT AVG(ThanhTien) FROM GiaoDich WHERE NguoiMoGioi = ?";

            PreparedStatement smtAll = connection.prepareStatement(sql);
            smtAll.setInt(1, maNguoiGiaoDich);
            ResultSet rs2 = smtAll.executeQuery();
            if (rs2.next()) {
                result = rs2.getFloat(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    //Amount giao dich
    @Override
    public int amountGiaoDichDat(int maNguoiGiaoDich) {
        int result = 0;
        try {
            String sql = "SELECT COUNT(GiaoDich.NguoiMoGioi) FROM GiaoDichDat INNER JOIN GiaoDich ON GiaoDich.MaGiaoDich = GiaoDichDat.MaGiaoDich WHERE NguoiMoGioi = ?";
            PreparedStatement smt = connection.prepareStatement(sql);
            smt.setInt(1, maNguoiGiaoDich);
            ResultSet rs = smt.executeQuery();
            while (rs.next()) {
                result = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    @Override
    public int amountGiaoDichNha(int maNguoiGiaoDich) {
        int result = 0;
        try {
            String sql = "SELECT COUNT(GiaoDich.NguoiMoGioi) FROM GiaoDichNha INNER JOIN GiaoDich ON GiaoDich.MaGiaoDich = GiaoDichNha.MaGiaoDich WHERE NguoiMoGioi = ?";
            PreparedStatement smt = connection.prepareStatement(sql);
            smt.setInt(1, maNguoiGiaoDich);
            ResultSet rs = smt.executeQuery();
            while (rs.next()) {
                result = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int amountGiaoDich(int maNguoiGiaoDich) {
        int result = 0;
        try {
            String sql = "SELECT COUNT(NguoiMoGioi) FROM GiaoDich WHERE NguoiMoGioi = ?";
            PreparedStatement smt = connection.prepareStatement(sql);
            smt.setInt(1, maNguoiGiaoDich);
            ResultSet rs = smt.executeQuery();
            while (rs.next()) {
                result = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    //GetGiaoDich
}
