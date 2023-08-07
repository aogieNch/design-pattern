package org.example.persistence;

import org.example.domain.model.GiaoDich;
import org.example.domain.model.GiaoDichDat;
import org.example.domain.model.GiaoDichNha;
import org.example.observer.DataObserver;

import java.util.List;

public interface GiaoDichGateWay {
    //GetGiaoDich
    List<GiaoDichDat> getGiaoDichDatByUserId(int maNguoiGiaoDich);
    List<GiaoDichNha> getGiaoDichNhaByUserId(int maNguoiGiaoDich);

    //AddGiaoDich
    void addGiaoDichDat(GiaoDichDat giaoDichDat);
    void addGiaoDichNha(GiaoDichNha giaoDichNha);

    //UpdateGiaoDich
    void updateGiaoDichDat(GiaoDichDat giaoDichDat);
    void updateGiaoDichNha(GiaoDichNha giaoDichNha);

    //SoftDeleteGiaoDich
    void softDeleteGiaoDich(int maGiaoDichDat, int maNguoiGiaoDich);

    //SearchGiaoDich
    GiaoDich getGiaoDichByMaGiaoDich(int mGiaoDich, int maNguoiGiaoDich);

    //Calulate Giao dich
    float calculateGiaoDichDat(int maNguoiGiaoDich);
    float calculateGiaoDichNha(int maNguoiGiaoDich);
    float calculateGiaoDich(int maNguoiGiaoDich);

    //Amount Giao dich
    int amountGiaoDichDat(int maNguoiGiaoDich);
    int amountGiaoDichNha(int maNguoiGiaoDich);
    int amountGiaoDich(int maNguoiGiaoDich);
}
