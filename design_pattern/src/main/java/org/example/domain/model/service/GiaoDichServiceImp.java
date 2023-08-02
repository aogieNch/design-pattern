package org.example.domain.model.service;

import org.example.domain.command.AddGiaoDichDat;
import org.example.domain.command.calculateGiaoDich.CalculateAvgGiaoDich;
import org.example.domain.command.calculateGiaoDich.CalculateAvgGiaoDichDat;
import org.example.domain.command.Command;
import org.example.domain.command.calculateGiaoDich.CalculateAvgGiaoDichNha;
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

    //CalculateAvgGiaoDichDat
    @Override
    public float calculateAvgGiaoDichDat(int maNguoiGiaoDich) {
        Command calculateGiaoDichDat = new CalculateAvgGiaoDichDat(giaoDichDAO, maNguoiGiaoDich);
        calculateGiaoDichDat.execute();
        return ((CalculateAvgGiaoDichDat) calculateGiaoDichDat).getResult();
    }
    @Override
    public float calculateAvgGiaoDichNha(int maNguoiGiaoDich) {
        Command calculateGiaoDichNha = new CalculateAvgGiaoDichNha(giaoDichDAO, maNguoiGiaoDich);
        calculateGiaoDichNha.execute();
        return ((CalculateAvgGiaoDichNha) calculateGiaoDichNha).getResult();
    }
    @Override
    public float calculateAvgGiaoDich(int maNguoiGiaoDich) {
        Command calculateGiaoDich = new CalculateAvgGiaoDich(giaoDichDAO, maNguoiGiaoDich);
        calculateGiaoDich.execute();
        return ((CalculateAvgGiaoDich) calculateGiaoDich).getResult();
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
