package org.example.domain.model.serviceImp;

import org.example.domain.model.GiaoDichDat;
import org.example.domain.model.service.GiaoDichDatService;
import org.example.persistence.GiaoDichDAO;
import org.example.persistence.GiaoDichDAOImp;
import org.example.persistence.GiaoDichGateWayImp;

import java.util.List;

public class GiaoDichDatServiceImp implements GiaoDichDatService {

    private GiaoDichDAO giaoDichDAO;

    public GiaoDichDatServiceImp() {
        giaoDichDAO = new GiaoDichDAOImp(new GiaoDichGateWayImp());
    }
    @Override
    public void addGiaoDichDat(GiaoDichDat giaoDichDat) {
        giaoDichDAO.addGiaoDichDat(giaoDichDat);
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
