package org.example.domain.model;

import java.time.LocalDate;

public abstract class GiaoDich {
    protected int maGiaoDich;
    protected LocalDate ngayGiaoDich;
    protected double donGia;
    protected double dienTich;
    protected int nguoiMoGioi;
    protected double thanhTien;

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
    public double getThanhTien() {
        return thanhTien;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public String getFormattedDonGia() {
        return formatMoney((float) getDonGia());
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public String getFormettedThanhTien() {
        return formatMoney((float) thanhTien());
    }

    private String formatMoney(float amount) {
        if (amount >= 1_000_000_000) {;
            return String.format("%,.0f ty", amount);
        } else if (amount >= 1_000_000) {
            return String.format("%,.0f tr", amount);
        } else {
            return String.format("%,.0f", amount);
        }
    }

    public abstract double thanhTien();
}
