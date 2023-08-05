package org.example.domain.model;

import java.time.LocalDate;

public class GiaoDichNha extends GiaoDich {
    private String diaChi;
    private LoaiNha loaiNha;
    private double thanhTien;

    public GiaoDichNha(int maGiaoDich, LocalDate ngayGiaoDich, double donGia, double dienTich, int nguoiMoGioi, String diaChi, LoaiNha loaiNha) {
        super(maGiaoDich, ngayGiaoDich, donGia, dienTich, nguoiMoGioi);
        this.diaChi = diaChi;
        this.loaiNha = loaiNha;
    }

    public LoaiNha getLoaiNha() {
        return loaiNha;
    }

    public String getDiaChi() {
        return diaChi;
    }


    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }
    public double getThanhTien(){
        return thanhTien;
    }

    @Override
    public double thanhTien(){
        if (loaiNha == LoaiNha.CAO_CAP) {
            return getDienTich() * getDonGia();
        } else {
            return getDienTich() * getDonGia() * 0.9;
        }
    }
}
