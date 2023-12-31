package org.example.presentation.controller;

import org.example.domain.model.GiaoDich;
import org.example.domain.model.GiaoDichDat;
import org.example.domain.model.GiaoDichNha;
import org.example.domain.model.service.GiaoDichService;

import java.util.List;

public class GiaoDichController {
    private final GiaoDichService giaoDichService;
    private GiaoDichDat giaoDichDat;
    private GiaoDichNha giaoDichNha;
    private final int maNguoiGiaoDich;

    public GiaoDichController(GiaoDichService giaoDichService, int maNguoiGiaoDich) {
        this.maNguoiGiaoDich = maNguoiGiaoDich;
        this.giaoDichService = giaoDichService;
    }

    public int getMaNguoiGiaoDich() {
        return maNguoiGiaoDich;
    }

    //GetGiaoDich
    public List<GiaoDichDat> getGiaoDichDatByUserId(int maNguoiGiaoDich) {
        return giaoDichService.getGiaoDichDatByUserId(maNguoiGiaoDich);
    }
    public List<GiaoDichNha> getGiaoDichNhaByUserId(int maNguoiGiaoDich) {
        return giaoDichService.getGiaoDichNhaByUserId(maNguoiGiaoDich);
    }

    //AddGiaoDich
    public void addGiaoDichDat(GiaoDichDat giaoDichDat) {
        giaoDichService.addGiaoDichDat(giaoDichDat);
    }

    public void addGiaoDichNha(GiaoDichNha giaoDichNha) {
        giaoDichService.addGiaoDichNha(giaoDichNha);
    }

    //UpdateGiaoDich
    public void updateGiaoDichDat(GiaoDichDat giaoDichDat) {
        giaoDichService.updateGiaoDichDat(giaoDichDat);
    }
    public void updateGiaoDichNha(GiaoDichNha giaoDichNha) {
        giaoDichService.updateGiaoDichNha(giaoDichNha);
    }

    //GetGiaoDich
    public GiaoDich getGiaoDichByMaGiaoDich(int maGiaoDich, int maNguoiGiaoDich) {
        return giaoDichService.getGiaoDichByMaGiaoDich(maGiaoDich, maNguoiGiaoDich);
    }
    //SoftDeleteGiaoDich
    public void softDeleteGiaoDich(int maGiaoDichDat, int maNguoiGiaoDich) {
        giaoDichService.softDeleteGiaoDich(maGiaoDichDat, maNguoiGiaoDich);
    }

    //CalculateAvgGiaoDich
    public float calculateGiaoDichDat(int maNguoiGiaoDich) {
        return giaoDichService.calculateAvgGiaoDichDat(maNguoiGiaoDich);
    }
    public float calculateGiaoDichNha(int maNguoiGiaoDich) {
        return giaoDichService.calculateAvgGiaoDichNha(maNguoiGiaoDich);
    }
    public float calculateGiaoDich(int maNguoiGiaoDich) {
        return giaoDichService.calculateAvgGiaoDich(maNguoiGiaoDich);
    }

    //AmountGiaoDich
    public int amountGiaoDichDat(int maNguoiGiaoDich) {
        return giaoDichService.amountGiaoDichDat(maNguoiGiaoDich);
    }
    public int amountGiaoDichNha(int maNguoiGiaoDich) {
        return giaoDichService.amountGiaoDichNha(maNguoiGiaoDich);
    }
    public int amountGiaoDich(int maNguoiGiaoDich) {
        return giaoDichService.amountGiaoDich(maNguoiGiaoDich);
    }
}
