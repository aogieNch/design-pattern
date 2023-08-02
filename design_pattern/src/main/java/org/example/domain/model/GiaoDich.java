package org.example.domain.model;

import java.time.LocalDate;

public abstract class GiaoDich {
    protected int maGiaoDich;
    protected LocalDate ngayGiaoDich;
    protected double donGia;
    protected double dienTich;
    protected int nguoiMoGioi;

    public GiaoDich(int maGiaoDich, LocalDate ngayGiaoDich, double donGia, double dienTich, int nguoiMoGioi) {
        this.maGiaoDich = maGiaoDich;
        this.ngayGiaoDich = ngayGiaoDich;
        this.donGia = donGia;
        this.dienTich = dienTich;
        this.nguoiMoGioi = nguoiMoGioi;
    }

    public GiaoDich() {
    }

    public int getMaGiaoDich() {
        return maGiaoDich;
    }

    public LocalDate getNgayGiaoDich() {
        return ngayGiaoDich;
    }

    public double getDonGia() {
        return donGia;
    }

    public double getDienTich() {
        return dienTich;
    }

    public int getNguoiMoGioi() {
        return nguoiMoGioi;
    }

    public abstract double thanhTien();
}
