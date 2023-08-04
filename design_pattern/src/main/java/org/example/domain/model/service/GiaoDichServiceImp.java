package org.example.domain.model.service;

import org.example.domain.command.addGiaoDich.AddGiaoDichDat;
import org.example.domain.command.addGiaoDich.AddGiaoDichNha;
import org.example.domain.command.calculateGiaoDich.CalculateAvgGiaoDich;
import org.example.domain.command.calculateGiaoDich.CalculateAvgGiaoDichDat;
import org.example.domain.command.Command;
import org.example.domain.command.calculateGiaoDich.CalculateAvgGiaoDichNha;
import org.example.domain.command.getGiaoDich.GetGiaoDichDat;
import org.example.domain.command.getGiaoDich.GetGiaoDichNha;
import org.example.domain.command.serchGiaoDich.GetGiaoDichByMaGiaoDich;
import org.example.domain.command.softDeleteGiaoDich.SoftDeleteGiaoDich;
import org.example.domain.command.totalAmount.AmountGiaoDich;
import org.example.domain.command.totalAmount.AmountGiaoDichDat;
import org.example.domain.command.totalAmount.AmountGiaoDichNha;
import org.example.domain.command.updateGiaoDich.UpdateGiaoDichDat;
import org.example.domain.command.updateGiaoDich.UpdateGiaoDichNha;
import org.example.domain.model.GiaoDich;
import org.example.domain.model.GiaoDichDat;
import org.example.domain.model.GiaoDichNha;
import org.example.persistence.GiaoDichDAO;

import java.util.List;

public class GiaoDichServiceImp implements GiaoDichService {

    private final GiaoDichDAO giaoDichDAO;

    public GiaoDichServiceImp(GiaoDichDAO giaoDichDAO) {
        this.giaoDichDAO = giaoDichDAO;
    }

    @Override
    public List<GiaoDichDat> getGiaoDichDatByUserId(int maNguoiGiaoDich) {
        GetGiaoDichDat getGiaoDichDat = new GetGiaoDichDat(giaoDichDAO, maNguoiGiaoDich);
        getGiaoDichDat.execute();

        return getGiaoDichDat.getGiaoDichDatList();
    }

    @Override
    public List<GiaoDichNha> getGiaoDichNhaByUserId(int maNguoiGiaoDich) {
        GetGiaoDichNha getGiaoDichNha = new GetGiaoDichNha(giaoDichDAO, maNguoiGiaoDich);
        getGiaoDichNha.execute();

        return getGiaoDichNha.getGiaoDichNhaList();
    }

    //AddGiaoDich
    @Override
    public void addGiaoDichDat(GiaoDichDat giaoDichDat) {
        Command addGiaoDichDat = new AddGiaoDichDat(giaoDichDAO, giaoDichDat);
        addGiaoDichDat.execute();
    }
    @Override
    public void addGiaoDichNha(GiaoDichNha giaoDichNha) {
        Command addGiaoDichNha = new AddGiaoDichNha(giaoDichDAO, giaoDichNha);
        addGiaoDichNha.execute();
    }

    //UpdateGiaoDich
    @Override
    public void updateGiaoDichDat(GiaoDichDat giaoDichDat) {
        UpdateGiaoDichDat updateGiaoDichDat = new UpdateGiaoDichDat(giaoDichDAO, giaoDichDat);
        updateGiaoDichDat.execute();
    }
    @Override
    public void updateGiaoDichNha(GiaoDichNha giaoDichNha) {
        UpdateGiaoDichNha updateGiaoDichNha = new UpdateGiaoDichNha(giaoDichDAO, giaoDichNha);
        updateGiaoDichNha.execute();
    }

    //GetGiaoDich
    @Override
    public GiaoDich getGiaoDichByMaGiaoDich(int maGiaoDich, int maNguoiGiaoDich) {
        GetGiaoDichByMaGiaoDich getGiaoDich = new GetGiaoDichByMaGiaoDich(giaoDichDAO, maGiaoDich, maNguoiGiaoDich);
        getGiaoDich.execute();
        return getGiaoDich.getGiaoDich();
    }

    //SoftDeleteGiaoDich
    @Override
    public void softDeleteGiaoDich(int maGiaoDich, int maNguoiGiaoDich) {
        SoftDeleteGiaoDich softDeleteGiaoDich = new SoftDeleteGiaoDich(giaoDichDAO, maGiaoDich, maNguoiGiaoDich);
        softDeleteGiaoDich.execute();
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
        AmountGiaoDichDat amountGiaoDichDat = new AmountGiaoDichDat(giaoDichDAO, maNguoiGiaoDich);
        amountGiaoDichDat.execute();
        return amountGiaoDichDat.getResult();
    }
    @Override
    public int amountGiaoDichNha(int maNguoiGiaoDich) {
        AmountGiaoDichNha amountGiaoDichNha = new AmountGiaoDichNha(giaoDichDAO, maNguoiGiaoDich);
        amountGiaoDichNha.execute();
        return amountGiaoDichNha.getResult();
    }
    @Override
    public int amountGiaoDich(int maNguoiGiaoDich) {
        AmountGiaoDich amountGiaoDich = new AmountGiaoDich(giaoDichDAO, maNguoiGiaoDich);
        amountGiaoDich.execute();
        return amountGiaoDich.getResult();
    }



}
