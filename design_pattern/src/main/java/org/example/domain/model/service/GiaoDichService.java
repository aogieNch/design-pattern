package org.example.domain.model.service;

import org.example.domain.model.GiaoDich;
import org.example.domain.model.GiaoDichDat;
import org.example.domain.model.GiaoDichNha;
import org.example.observer.DataObserver;

import java.util.List;

public interface GiaoDichService {
    //GetGiaoDich
    List<GiaoDichDat> getGiaoDichDatByUserId(int maNguoiGiaoDich);
    List<GiaoDichNha> getGiaoDichNhaByUserId(int maNguoiGiaoDich);

    //AddGiaoDich
    void addGiaoDichDat(GiaoDichDat giaoDichDat);
    void addGiaoDichNha(GiaoDichNha giaoDichNha);

    //UpdateGiaoDich
    void updateGiaoDichDat(GiaoDichDat giaoDichDat);
    void updateGiaoDichNha(GiaoDichNha giaoDichNha);

    //GetGiaoDich
    GiaoDich getGiaoDichByMaGiaoDich(int mGiaoDich, int maNguoiGiaoDich);

    //SoftDeleteGiaoDich
    void softDeleteGiaoDich(int maGiaoDichDat, int maNguoiGiaoDich);

    //CalculateAvgGiaoDich
    float calculateAvgGiaoDichDat(int maNguoiGiaoDich);
    float calculateAvgGiaoDichNha(int maNguoiGiaoDich);
    float calculateAvgGiaoDich(int maNguoiGiaoDich);

    //Amount Giao dich
    int amountGiaoDichDat(int maNguoiGiaoDich);
    int amountGiaoDichNha(int maNguoiGiaoDich);
    int amountGiaoDich(int maNguoiGiaoDich);

    void registerObserver(DataObserver observer);
}
