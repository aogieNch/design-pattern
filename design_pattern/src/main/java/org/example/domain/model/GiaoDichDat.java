package org.example.domain.model;

import org.example.persistence.GiaoDichDAO;

import java.time.LocalDate;

public class GiaoDichDat extends GiaoDich{

    private GiaoDichDAO giaoDichDAO;
    private LoaiDat loaiDat;

    public GiaoDichDat(int maGiaoDich, LocalDate ngayGiaoDich, double donGia, double dienTich, int nguoiMoGioi, LoaiDat loaiDat) {
        super(maGiaoDich, ngayGiaoDich, donGia, dienTich, nguoiMoGioi);
        this.loaiDat = loaiDat;
    }

    public GiaoDichDat(GiaoDichDAO giaoDichDAO) {
        this.giaoDichDAO = giaoDichDAO;
    }

    public LoaiDat getLoaiDat() {
        return loaiDat;
    }

    public void addGiaoDichDat(GiaoDichDat giaoDichDat) {
        giaoDichDAO.addGiaoDichDat(giaoDichDat);
    }

    @Override
    public double thanhTien() {
        if (loaiDat == LoaiDat.A) {
            return getDienTich() * getDonGia() * 1.5;
        } else {
            return getDienTich() * getDonGia();
        }
    }
}
