package org.example.domain.model.service;

import org.example.domain.model.GiaoDichDat;
import org.example.domain.model.GiaoDichNha;

public interface GiaoDichService {
    void addGiaoDichDat(GiaoDichDat giaoDichDat);
    float calculateGiaoDichDat(int maNguoiGiaoDich);
}
