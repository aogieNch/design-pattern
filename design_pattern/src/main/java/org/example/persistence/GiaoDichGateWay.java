package org.example.persistence;

import org.example.domain.model.GiaoDichDat;

import java.util.List;

public interface GiaoDichGateWay {
    void addGiaoDichDat(GiaoDichDat giaoDichDat);
    void updateGiaoDichDat(GiaoDichDat giaoDichDat);
    void deleteGiaoDichDat(GiaoDichDat giaoDichDat);
    GiaoDichDat getGiaoDichDatById(int id);
    List<GiaoDichDat> getAllGiaoDichDat();
}