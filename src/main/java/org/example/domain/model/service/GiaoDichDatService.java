package org.example.domain.model.service;

import org.example.domain.model.GiaoDichDat;

import java.util.List;

public interface GiaoDichDatService {
    void addGiaoDichDat(GiaoDichDat giaoDichDat);
    void updateGiaoDichDat(GiaoDichDat giaoDichDat);
    void deleteGiaoDichDat(GiaoDichDat giaoDichDat);

    GiaoDichDat getGiaoDichDatById(int id);

    List<GiaoDichDat> getAllGiaoDichDat();
}
