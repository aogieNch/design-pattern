package org.example.domain.model;

import java.time.LocalDate;

public class GiaoDichDat extends GiaoDich {
    private final LoaiDat loaiDat;

    public GiaoDichDat(int maGiaoDich, LocalDate ngayGiaoDich, double donGia, double dienTich, int nguoiMoGioi, LoaiDat loaiDat) {
        super(maGiaoDich, ngayGiaoDich, donGia, dienTich, nguoiMoGioi);
        this.loaiDat = loaiDat;
    }

    public LoaiDat getLoaiDat() {
        return loaiDat;
    }

    //set thanh tien
    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
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
