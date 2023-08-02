package org.example.domain.model.service;

import org.example.domain.command.AddGiaoDichDat;
import org.example.domain.command.CalculateGiaoDichDat;
import org.example.domain.command.Command;
import org.example.domain.model.GiaoDichDat;
import org.example.persistence.GiaoDichDAO;

public class GiaoDichServiceImp implements GiaoDichService {

    private GiaoDichDAO giaoDichDAO;

    public GiaoDichServiceImp(GiaoDichDAO giaoDichDAO) {
        this.giaoDichDAO = giaoDichDAO;
    }

    @Override
    public void addGiaoDichDat(GiaoDichDat giaoDichDat) {
        Command addGiaoDichDat = new AddGiaoDichDat(giaoDichDAO, giaoDichDat);
        addGiaoDichDat.execute();
    }

    @Override
    public float calculateGiaoDichDat(int maNguoiGiaoDich) {
        Command calculateGiaoDichDat = new CalculateGiaoDichDat(giaoDichDAO, maNguoiGiaoDich);
        calculateGiaoDichDat.execute();
        return ((CalculateGiaoDichDat) calculateGiaoDichDat).getResult();
    }
}
