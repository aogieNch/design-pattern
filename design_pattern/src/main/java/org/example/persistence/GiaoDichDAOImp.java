package org.example.persistence;

import org.example.domain.model.GiaoDich;
import org.example.domain.model.GiaoDichDat;

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
    public void updateGiaoDichDat(GiaoDichDat giaoDichDat) {

    }

    @Override
    public void deleteGiaoDichDat(GiaoDichDat giaoDichDat) {

    }

    @Override
    public GiaoDichDat getGiaoDichDatById(int id) {
        return null;
    }

    @Override
    public List<GiaoDichDat> getAllGiaoDichDat() {
        return null;
    }
}
