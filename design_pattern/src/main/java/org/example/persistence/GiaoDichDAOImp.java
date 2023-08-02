package org.example.persistence;

import org.example.domain.model.GiaoDichDat;

import java.util.List;

public class GiaoDichDAOImp implements GiaoDichDAO {
    private GiaoDichGateWay giaoDichGateWay;
    public GiaoDichDAOImp(GiaoDichGateWay giaoDichGateWay) {
        this.giaoDichGateWay = giaoDichGateWay;
    }

    //GetGiaoDich
    @Override
    public List<GiaoDichDat> getGiaoDichDatByUserId(int maNguoiGiaoDich) {
        return giaoDichGateWay.getGiaoDichDatByUserId(maNguoiGiaoDich);
    }

    //AddGiaoDich
    @Override
    public void addGiaoDichDat(GiaoDichDat giaoDichDat) {
        giaoDichGateWay.addGiaoDichDat(giaoDichDat);
    }

    //Calculate Avg Giao Dich
    @Override
    public float calculateGiaoDichDat(int maNguoiGiaoDich) {
        return giaoDichGateWay.calculateGiaoDichDat(maNguoiGiaoDich);
    }
    @Override
    public float calculateGiaoDichNha(int maNguoiGiaoDich) {
        return giaoDichGateWay.calculateGiaoDichNha(maNguoiGiaoDich);
    }
    @Override
    public float calculateGiaoDich(int maNguoiGiaoDich) {
        return giaoDichGateWay.calculateGiaoDich(maNguoiGiaoDich);
    }

    //Amount Giao Dich
    @Override
    public int amountGiaoDichDat(int maNguoiGiaoDich) {
        return giaoDichGateWay.amountGiaoDichDat(maNguoiGiaoDich);
    }
    @Override
    public int amountGiaoDichNha(int maNguoiGiaoDich) {
        return giaoDichGateWay.amountGiaoDichNha(maNguoiGiaoDich);
    }
    @Override
    public int amountGiaoDich(int maNguoiGiaoDich) {
        return giaoDichGateWay.amountGiaoDich(maNguoiGiaoDich);
    }
}
