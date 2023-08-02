package org.example.domain.model.service;

import org.example.domain.model.GiaoDichDat;

public interface GiaoDichService {
    void addGiaoDichDat(GiaoDichDat giaoDichDat);
    float calculateAvgGiaoDichDat(int maNguoiGiaoDich);
    float calculateAvgGiaoDichNha(int maNguoiGiaoDich);
    float calculateAvgGiaoDich(int maNguoiGiaoDich);

    //Amount Giao dich
    int amountGiaoDichDat(int maNguoiGiaoDich);
    int amountGiaoDichNha(int maNguoiGiaoDich);
    int amountGiaoDich(int maNguoiGiaoDich);
}
