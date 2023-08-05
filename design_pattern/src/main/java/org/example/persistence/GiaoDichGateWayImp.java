package org.example.persistence;

import org.example.domain.model.*;
import org.example.observer.DataObserver;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GiaoDichGateWayImp implements GiaoDichGateWay {

    private Connection connection;
    private final List<DataObserver> observers = new ArrayList<>();

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
    public void registerObserver(DataObserver observer){
        observers.add(observer);
    }

    public void notifyObservers() {
        for (DataObserver observer : observers) {
            observer.onDataChanged();
        }
    }
    //Fetch data from database
    @Override
    public List<GiaoDichDat> getGiaoDichDatByUserId(int maNguoiGiaoDich) {
        List<GiaoDichDat> giaoDichList = new ArrayList<>();
        try {
            String sql = "SELECT GiaoDich.MaGiaoDich, GiaoDich.NgayGiaoDich, GiaoDich.DonGia, GiaoDich.DienTich, LoaiDat.TenLoaiDat, GiaoDich.ThanhTien " +
                    "FROM ((GiaoDich " +
                    "INNER JOIN GiaoDichDat ON GiaoDich.MaGiaoDich = GiaoDichDat.MaGiaoDich) " +
                    "INNER JOIN LoaiDat ON GiaoDichDat.LoaiDat = LoaiDat.MaLoaiDat) " +
                    "WHERE GiaoDich.NguoiMoGioi = ? AND GiaoDich.is_deleted = 0";

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, maNguoiGiaoDich);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int maGiaoDich = rs.getInt("MaGiaoDich");
                LocalDate ngayGiaoDich = rs.getDate("NgayGiaoDich").toLocalDate();
                double donGia = rs.getDouble("DonGia");
                double dienTich = rs.getDouble("DienTich");
                String tenLoaiDat = rs.getString("TenLoaiDat");
                double thanhTien = rs.getDouble("ThanhTien");

                // Convert the tenLoaiDat String to a LoaiDat enum
                LoaiDat loaiDat = LoaiDat.valueOf(tenLoaiDat);

                // Create a GiaoDich object with the retrieved data
                GiaoDichDat giaoDich = new GiaoDichDat(maGiaoDich, ngayGiaoDich, donGia, dienTich, maNguoiGiaoDich, loaiDat);
                giaoDich.setThanhTien(thanhTien);

                // Add the GiaoDich to the list
                giaoDichList.add(giaoDich);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return giaoDichList;
    }
    @Override
    public List<GiaoDichNha> getGiaoDichNhaByUserId(int maNguoiGiaoDich) {
        List<GiaoDichNha> giaoDichList = new ArrayList<>();
        try {
            String sql = "SELECT GiaoDich.MaGiaoDich, GiaoDich.NgayGiaoDich, GiaoDich.DonGia, GiaoDich.DienTich, LoaiNha.TenLoaiNha, GiaoDichNha.DiaChi, GiaoDich.ThanhTien " +
                    "FROM ((GiaoDich " +
                    "INNER JOIN GiaoDichNha ON GiaoDich.MaGiaoDich = GiaoDichNha.MaGiaoDich) " +
                    "INNER JOIN LoaiNha ON GiaoDichNha.LoaiNha = LoaiNha.MaLoaiNha) " +
                    "WHERE GiaoDich.NguoiMoGioi = ? AND GiaoDich.is_deleted = 0";

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, maNguoiGiaoDich);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int maGiaoDich = rs.getInt("MaGiaoDich");
                LocalDate ngayGiaoDich = rs.getDate("NgayGiaoDich").toLocalDate();
                double donGia = rs.getDouble("DonGia");
                double dienTich = rs.getDouble("DienTich");
                String diaChi = rs.getString("DiaChi");
                String tenLoaiNha = rs.getString("TenLoaiNha");
                double thanhTien = rs.getDouble("ThanhTien");

                // Convert the tenLoaiNha String to a LoaiNha enum value
                LoaiNha loaiNha = LoaiNha.fromString(tenLoaiNha);
                // Create a GiaoDich object with the retrieved data
                GiaoDichNha giaoDich = new GiaoDichNha(maGiaoDich, ngayGiaoDich, donGia, dienTich, maNguoiGiaoDich, diaChi, loaiNha);
                giaoDich.setThanhTien(thanhTien);

                // Add the GiaoDich to the list
                giaoDichList.add(giaoDich);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return giaoDichList;
    }

    //AddGiaoDich
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
        notifyObservers();
    }

    @Override
    public void addGiaoDichNha(GiaoDichNha giaoDichNha) {
        try {
            // Thêm dữ liệu vào bảng GiaoDich
            String insertGiaoDichSql = "INSERT INTO GiaoDich (MaGiaoDich, NgayGiaoDich, DonGia, DienTich, ThanhTien, NguoiMoGioi) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement insertGiaoDichStmt = connection.prepareStatement(insertGiaoDichSql, Statement.RETURN_GENERATED_KEYS);
            insertGiaoDichStmt.setInt(1, giaoDichNha.getMaGiaoDich());
            insertGiaoDichStmt.setDate(2, Date.valueOf(giaoDichNha.getNgayGiaoDich()));
            insertGiaoDichStmt.setDouble(3, giaoDichNha.getDonGia());
            insertGiaoDichStmt.setDouble(4, giaoDichNha.getDienTich());
            insertGiaoDichStmt.setDouble(5, giaoDichNha.thanhTien());
            insertGiaoDichStmt.setString(6, String.valueOf(giaoDichNha.getNguoiMoGioi()));
            insertGiaoDichStmt.executeUpdate();

            // Thêm dữ liệu vào bảng GiaoDichNha
            String insertGiaoDichNhaSql = "INSERT INTO GiaoDichNha (DiaChi, MaGiaoDich, LoaiNha) VALUES (?, ?, ?)";
            PreparedStatement insertGiaoDichNhaStmt = connection.prepareStatement(insertGiaoDichNhaSql);
            insertGiaoDichNhaStmt.setString(1, giaoDichNha.getDiaChi());
            insertGiaoDichNhaStmt.setInt(2, giaoDichNha.getMaGiaoDich());
            insertGiaoDichNhaStmt.setInt(3, giaoDichNha.getLoaiNha().ordinal() + 1);
            insertGiaoDichNhaStmt.executeUpdate();

            System.out.println("Thêm giao dịch Nha thành công.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        notifyObservers();
    }

    //Update Giao dich
    @Override
    public void updateGiaoDichDat(GiaoDichDat giaoDichDat) {
        try {
            // Cập nhật dữ liệu trong bảng GiaoDich
            String updateGiaoDichSql = "UPDATE GiaoDich SET NgayGiaoDich = ?, DonGia = ?, DienTich = ?, ThanhTien = ?, NguoiMoGioi = ? WHERE MaGiaoDich = ?";
            PreparedStatement updateGiaoDichStmt = connection.prepareStatement(updateGiaoDichSql);
            updateGiaoDichStmt.setDate(1, Date.valueOf(giaoDichDat.getNgayGiaoDich()));
            updateGiaoDichStmt.setDouble(2, giaoDichDat.getDonGia());
            updateGiaoDichStmt.setDouble(3, giaoDichDat.getDienTich());
            updateGiaoDichStmt.setDouble(4, giaoDichDat.thanhTien());
            updateGiaoDichStmt.setString(5, String.valueOf(giaoDichDat.getNguoiMoGioi()));
            updateGiaoDichStmt.setInt(6, giaoDichDat.getMaGiaoDich());
            updateGiaoDichStmt.executeUpdate();

            // Cập nhật dữ liệu trong bảng GiaoDichDat
            String updateGiaoDichDatSql = "UPDATE GiaoDichDat SET LoaiDat = ? WHERE MaGiaoDich = ?";
            PreparedStatement updateGiaoDichDatStmt = connection.prepareStatement(updateGiaoDichDatSql);
            updateGiaoDichDatStmt.setInt(1, giaoDichDat.getLoaiDat().ordinal() + 1);
            updateGiaoDichDatStmt.setInt(2, giaoDichDat.getMaGiaoDich());
            updateGiaoDichDatStmt.executeUpdate();

            notifyObservers();
            System.out.println("Cập nhật giao dịch đất thành công.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateGiaoDichNha(GiaoDichNha giaoDichNha) {
        try {
            // Cập nhật dữ liệu trong bảng GiaoDich
            String updateGiaoDichSql = "UPDATE GiaoDich SET NgayGiaoDich = ?, DonGia = ?, DienTich = ?, ThanhTien = ?, NguoiMoGioi = ? WHERE MaGiaoDich = ?";
            PreparedStatement updateGiaoDichStmt = connection.prepareStatement(updateGiaoDichSql);
            updateGiaoDichStmt.setDate(1, Date.valueOf(giaoDichNha.getNgayGiaoDich()));
            updateGiaoDichStmt.setDouble(2, giaoDichNha.getDonGia());
            updateGiaoDichStmt.setDouble(3, giaoDichNha.getDienTich());
            updateGiaoDichStmt.setDouble(4, giaoDichNha.thanhTien());
            updateGiaoDichStmt.setString(5, String.valueOf(giaoDichNha.getNguoiMoGioi()));
            updateGiaoDichStmt.setInt(6, giaoDichNha.getMaGiaoDich());
            updateGiaoDichStmt.executeUpdate();

            // Cập nhật dữ liệu trong bảng GiaoDichNha
            String updateGiaoDichNhaSql = "UPDATE GiaoDichNha SET DiaChi = ?, LoaiNha = ? WHERE MaGiaoDich = ?";
            PreparedStatement updateGiaoDichNhaStmt = connection.prepareStatement(updateGiaoDichNhaSql);
            updateGiaoDichNhaStmt.setString(1, giaoDichNha.getDiaChi());
            updateGiaoDichNhaStmt.setInt(2, giaoDichNha.getLoaiNha().ordinal() + 1);
            updateGiaoDichNhaStmt.setInt(3, giaoDichNha.getMaGiaoDich());
            updateGiaoDichNhaStmt.executeUpdate();

            notifyObservers();
            System.out.println("Cập nhật giao dịch Nhà thành công.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Get giao dich
    private GiaoDichDat getGiaoDichDatByMaGiaoDich(int maGiaoDich, int maNguoiMoGioi) {
        try {
            String sql = "SELECT GiaoDich.MaGiaoDich, GiaoDich.NgayGiaoDich, GiaoDich.DonGia, GiaoDich.DienTich, LoaiDat.TenLoaiDat, GiaoDich.ThanhTien " +
                    "FROM ((GiaoDich " +
                    "INNER JOIN GiaoDichDat ON GiaoDich.MaGiaoDich = GiaoDichDat.MaGiaoDich) " +
                    "INNER JOIN LoaiDat ON GiaoDichDat.LoaiDat = LoaiDat.MaLoaiDat) " +
                    "WHERE GiaoDich.NguoiMoGioi = ? AND GiaoDich.is_deleted = 0 AND GiaoDich.MaGiaoDich = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, maNguoiMoGioi);
            stmt.setInt(2, maGiaoDich);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int maGiaoDichDat = rs.getInt("MaGiaoDich");
                LocalDate ngayGiaoDich = rs.getDate("NgayGiaoDich").toLocalDate();
                double donGia = rs.getDouble("DonGia");
                double dienTich = rs.getDouble("DienTich");

                LoaiDat loaiDat = LoaiDat.fromString(rs.getString("TenLoaiDat"));
                double thanhTien = rs.getDouble("ThanhTien");

                GiaoDichDat giaoDichDat = new GiaoDichDat(maGiaoDichDat, ngayGiaoDich, donGia, dienTich, maNguoiMoGioi, loaiDat);
                giaoDichDat.setThanhTien(thanhTien);

                return giaoDichDat;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private GiaoDichNha getGiaoDichNhaByMaGiaoDich(int maGiaoDich, int maNguoiMoGioi) {
        try {
            String sql = "SELECT GiaoDich.MaGiaoDich, GiaoDich.NgayGiaoDich, GiaoDich.DonGia, GiaoDich.DienTich, LoaiNha.TenLoaiNha, GiaoDichNha.DiaChi, GiaoDich.ThanhTien " +
                    "FROM ((GiaoDich " +
                    "INNER JOIN GiaoDichNha ON GiaoDich.MaGiaoDich = GiaoDichNha.MaGiaoDich) " +
                    "INNER JOIN LoaiNha ON GiaoDichNha.LoaiNha = LoaiNha.MaLoaiNha) " +
                    "WHERE GiaoDich.NguoiMoGioi = ? AND GiaoDich.is_deleted = 0 AND GiaoDich.MaGiaoDich = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, maNguoiMoGioi);
            stmt.setInt(2, maGiaoDich);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int maGiaoDichNha = rs.getInt("MaGiaoDich");
                LocalDate ngayGiaoDich = rs.getDate("NgayGiaoDich").toLocalDate();
                double donGia = rs.getDouble("DonGia");
                LoaiNha loaiNha = LoaiNha.fromString(rs.getString("TenLoaiNha"));
                String diaChi = rs.getString("DiaChi");
                double dienTich = rs.getDouble("DienTich");
                double thanhTien = rs.getDouble("ThanhTien");

                GiaoDichNha giaoDichNha = new GiaoDichNha(maGiaoDichNha, ngayGiaoDich, donGia, dienTich, maNguoiMoGioi, diaChi, loaiNha);
                giaoDichNha.setThanhTien(thanhTien);

                return giaoDichNha;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public GiaoDich getGiaoDichByMaGiaoDich(int maGiaoDich, int maNguoiMoGioi) {
        GiaoDichDat giaoDichDat = getGiaoDichDatByMaGiaoDich(maGiaoDich, maNguoiMoGioi);
        if (giaoDichDat != null) {
            return giaoDichDat;
        }

        return getGiaoDichNhaByMaGiaoDich(maGiaoDich, maNguoiMoGioi);
    }
    //Soft delete Giao Dich
    @Override
    public void softDeleteGiaoDich(int maGiaoDich, int maNguoiMoGioi) {
        try {
            GiaoDich giaoDich = getGiaoDichByMaGiaoDich(maGiaoDich, maNguoiMoGioi);

            if (giaoDich != null) {
                String updateGiaoDichSql = "UPDATE GiaoDich SET is_deleted = 1 WHERE MaGiaoDich = ? AND NguoiMoGioi = ?";
                PreparedStatement updateGiaoDichStmt = connection.prepareStatement(updateGiaoDichSql);
                updateGiaoDichStmt.setInt(1, maGiaoDich);
                updateGiaoDichStmt.setInt(2, maNguoiMoGioi);
                updateGiaoDichStmt.executeUpdate();

                if (giaoDich instanceof GiaoDichDat) {
                    String updateGiaoDichDatSql = "UPDATE GiaoDichDat SET is_deleted = 1 WHERE MaGiaoDich = ?";
                    PreparedStatement updateGiaoDichDatStmt = connection.prepareStatement(updateGiaoDichDatSql);
                    updateGiaoDichDatStmt.setInt(1, maGiaoDich);
                    updateGiaoDichDatStmt.executeUpdate();
                    System.out.println("Soft delete successful from GiaoDichDat.");
                } else if (giaoDich instanceof GiaoDichNha) {
                    String updateGiaoDichNhaSql = "UPDATE GiaoDichNha SET is_deleted = 1 WHERE MaGiaoDich = ?";
                    PreparedStatement updateGiaoDichNhaStmt = connection.prepareStatement(updateGiaoDichNhaSql);
                    updateGiaoDichNhaStmt.setInt(1, maGiaoDich);
                    updateGiaoDichNhaStmt.executeUpdate();
                    System.out.println("Soft delete successful from GiaoDichNha.");
                }
            } else {
                // Handle the case when the maGiaoDich doesn't exist in any table
                System.out.println("GiaoDich not found.");
            }
            notifyObservers();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception if needed
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

}
