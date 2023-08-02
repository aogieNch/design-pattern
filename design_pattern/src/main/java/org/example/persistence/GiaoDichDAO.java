package org.example.persistence;

import org.example.domain.model.GiaoDich;
import org.example.domain.model.GiaoDichDat;
import org.example.domain.model.GiaoDichNha;

import java.util.List;

public interface GiaoDichDAO {
    void addGiaoDichDat(GiaoDichDat giaoDichDat);
    float calculateGiaoDichDat(int maNguoiGiaoDich);
}
