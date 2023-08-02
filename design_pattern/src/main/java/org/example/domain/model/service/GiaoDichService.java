package org.example.domain.model.service;

import org.example.domain.model.GiaoDichDat;

public interface GiaoDichService {

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
