package org.example.presentation.controller;

import org.example.domain.model.GiaoDichDat;
import org.example.domain.model.GiaoDichNha;
import org.example.domain.model.service.GiaoDichService;

public class GiaoDichController {
    private GiaoDichService giaoDichService;
    private GiaoDichDat giaoDichDat;
    private GiaoDichNha giaoDichNha;

    public GiaoDichController(GiaoDichService giaoDichService) {
        this.giaoDichService = giaoDichService;
    }

    public void addGiaoDichDat(GiaoDichDat giaoDichDat) {
        giaoDichService.addGiaoDichDat(giaoDichDat);
    }
    public float calculateGiaoDichDat(int maNguoiGiaoDich) {
        return giaoDichService.calculateGiaoDichDat(maNguoiGiaoDich);
    }
}
