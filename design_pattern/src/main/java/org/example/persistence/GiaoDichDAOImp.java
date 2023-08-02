package org.example.persistence;

import org.example.domain.model.GiaoDich;
import org.example.domain.model.GiaoDichDat;
import org.example.domain.model.GiaoDichNha;

import java.util.List;

public class GiaoDichDAOImp implements GiaoDichDAO {

    private GiaoDichGateWay giaoDichGateWay;
    public GiaoDichDAOImp(GiaoDichGateWay giaoDichGateWay) {
        this.giaoDichGateWay = giaoDichGateWay;
    }
    @Override
    public void addGiaoDichDat(GiaoDichDat giaoDichDat) {
        giaoDichGateWay.addGiaoDichDat(giaoDichDat);
    }

    @Override
    public float calculateGiaoDichDat(int maNguoiGiaoDich) {
        return giaoDichGateWay.calculateGiaoDichDat(maNguoiGiaoDich);
    }
}
