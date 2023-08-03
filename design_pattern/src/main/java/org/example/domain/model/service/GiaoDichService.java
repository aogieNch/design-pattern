package org.example.domain.model.service;

import org.example.domain.model.GiaoDichDat;
import org.example.domain.model.GiaoDichNha;

import java.util.List;

public interface GiaoDichService {
    //GetGiaoDich
    List<GiaoDichDat> getGiaoDichDatByUserId(int maNguoiGiaoDich);
    List<GiaoDichNha> getGiaoDichNhaByUserId(int maNguoiGiaoDich);

    //AddGiaoDich
    void addGiaoDichDat(GiaoDichDat giaoDichDat);

    //CalculateAvgGiaoDich
    float calculateAvgGiaoDichDat(int maNguoiGiaoDich);
    float calculateAvgGiaoDichNha(int maNguoiGiaoDich);
    float calculateAvgGiaoDich(int maNguoiGiaoDich);

    //Amount Giao dich
    int amountGiaoDichDat(int maNguoiGiaoDich);
    int amountGiaoDichNha(int maNguoiGiaoDich);
    int amountGiaoDich(int maNguoiGiaoDich);
}
