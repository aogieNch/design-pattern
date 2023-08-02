package org.example.domain.command;

import org.example.domain.model.GiaoDichDat;
import org.example.persistence.GiaoDichDAO;

public class CalculateGiaoDichDat implements Command {
    private GiaoDichDAO giaoDichDAO;
    private int maNguoiGiaoDich;
    private float result;

    public CalculateGiaoDichDat(GiaoDichDAO giaoDichDAO, int maNguoiGiaoDich) {
        this.giaoDichDAO = giaoDichDAO;
        this.maNguoiGiaoDich = maNguoiGiaoDich;
    }

    public float getResult(){
        return result;
    }
    @Override
    public void execute() {
        result = giaoDichDAO.calculateGiaoDichDat(maNguoiGiaoDich);
    }
}
