package org.example.persistence;

import org.example.domain.model.GiaoDich;
import org.example.domain.model.GiaoDichDat;
import org.example.domain.model.GiaoDichNha;

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
    @Override
    public List<GiaoDichNha> getGiaoDichNhaByUserId(int maNguoiGiaoDich) {
        return giaoDichGateWay.getGiaoDichNhaByUserId(maNguoiGiaoDich);
    }

    //AddGiaoDich
    @Override
    public void addGiaoDichDat(GiaoDichDat giaoDichDat) {
        giaoDichGateWay.addGiaoDichDat(giaoDichDat);
    }

    @Override
    public void addGiaoDichNha(GiaoDichNha giaoDichNha) {
        giaoDichGateWay.addGiaoDichNha(giaoDichNha);
    }

    //UpdateGiaoDich
    @Override
    public void updateGiaoDichDat(GiaoDichDat giaoDichDat) {
        giaoDichGateWay.updateGiaoDichDat(giaoDichDat);
    }

    @Override
    public void updateGiaoDichNha(GiaoDichNha giaoDichNha){
        giaoDichGateWay.updateGiaoDichNha(giaoDichNha);
    }

    //GetGiaoDich
    @Override
    public GiaoDich getGiaoDichByMaGiaoDich(int mGiaoDich, int maNguoiGiaoDich) {
        return giaoDichGateWay.getGiaoDichByMaGiaoDich(mGiaoDich, maNguoiGiaoDich);
    }

    //SoftDeleteGiaoDich
    @Override
    public void softDeleteGiaoDich(int maGiaoDichDat, int maNguoiGiaoDich) {
        giaoDichGateWay.softDeleteGiaoDich(maGiaoDichDat, maNguoiGiaoDich);
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
