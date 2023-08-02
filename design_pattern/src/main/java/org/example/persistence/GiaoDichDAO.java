package org.example.persistence;

import org.example.domain.model.GiaoDichDat;

public interface GiaoDichDAO {
    void addGiaoDichDat(GiaoDichDat giaoDichDat);

    //Calculate Giao dich
    float calculateGiaoDichDat(int maNguoiGiaoDich);
    float calculateGiaoDichNha(int maNguoiGiaoDich);
    float calculateGiaoDich(int maNguoiGiaoDich);

    //Amount Giao dich
    int amountGiaoDichDat(int maNguoiGiaoDich);
    int amountGiaoDichNha(int maNguoiGiaoDich);
    int amountGiaoDich(int maNguoiGiaoDich);
}
