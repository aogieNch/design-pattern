package org.example.presentation.controller;

import org.example.domain.model.GiaoDichDat;
import org.example.domain.model.GiaoDichNha;
import org.example.domain.model.service.GiaoDichService;

import java.util.List;

public class GiaoDichController {
    private final GiaoDichService giaoDichService;
    private GiaoDichDat giaoDichDat;
    private GiaoDichNha giaoDichNha;

    public GiaoDichController(GiaoDichService giaoDichService) {
        this.giaoDichService = giaoDichService;
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
