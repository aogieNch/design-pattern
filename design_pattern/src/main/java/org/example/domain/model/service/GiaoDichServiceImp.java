package org.example.domain.model.service;

import org.example.domain.command.addGiaoDich.AddGiaoDichDat;
import org.example.domain.command.calculateGiaoDich.CalculateAvgGiaoDich;
import org.example.domain.command.calculateGiaoDich.CalculateAvgGiaoDichDat;
import org.example.domain.command.Command;
import org.example.domain.command.calculateGiaoDich.CalculateAvgGiaoDichNha;
import org.example.domain.model.GiaoDichDat;
import org.example.persistence.GiaoDichDAO;

public class GiaoDichServiceImp implements GiaoDichService {

    private final GiaoDichDAO giaoDichDAO;

    public GiaoDichServiceImp(GiaoDichDAO giaoDichDAO) {
        this.giaoDichDAO = giaoDichDAO;
    }

    @Override
    public void addGiaoDichDat(GiaoDichDat giaoDichDat) {
        Command addGiaoDichDat = new AddGiaoDichDat(giaoDichDAO, giaoDichDat);
        addGiaoDichDat.execute();
    }

    //CalculateAvgGiaoDichDat
    @Override
    public float calculateAvgGiaoDichDat(int maNguoiGiaoDich) {
        CalculateAvgGiaoDichDat calculateGiaoDichDat = new CalculateAvgGiaoDichDat(giaoDichDAO, maNguoiGiaoDich);
        calculateGiaoDichDat.execute();
        return calculateGiaoDichDat.getResult();
    }
    @Override
    public float calculateAvgGiaoDichNha(int maNguoiGiaoDich) {
        CalculateAvgGiaoDichNha calculateGiaoDichNha = new CalculateAvgGiaoDichNha(giaoDichDAO, maNguoiGiaoDich);
        calculateGiaoDichNha.execute();
        return calculateGiaoDichNha.getResult();
    }
    @Override
    public float calculateAvgGiaoDich(int maNguoiGiaoDich) {
        CalculateAvgGiaoDich calculateGiaoDich = new CalculateAvgGiaoDich(giaoDichDAO, maNguoiGiaoDich);
        calculateGiaoDich.execute();
        return calculateGiaoDich.getResult();
    }

    //AmountGiaoDich
    @Override
    public int amountGiaoDichDat(int maNguoiGiaoDich) {
        return giaoDichDAO.amountGiaoDichDat(maNguoiGiaoDich);
    }
    @Override
    public int amountGiaoDichNha(int maNguoiGiaoDich) {
        return giaoDichDAO.amountGiaoDichNha(maNguoiGiaoDich);
    }
    @Override
    public int amountGiaoDich(int maNguoiGiaoDich) {
        return giaoDichDAO.amountGiaoDich(maNguoiGiaoDich);
    }

}
