package org.example.domain.command.calculateGiaoDich;

import org.example.domain.command.Command;
import org.example.persistence.GiaoDichDAO;

public class CalculateAvgGiaoDich implements Command {
    private GiaoDichDAO giaoDichDAO;
    private int maNguoiGiaoDich;
    private float result;

    public CalculateAvgGiaoDich(GiaoDichDAO giaoDichDAO, int maNguoiGiaoDich) {
        this.giaoDichDAO = giaoDichDAO;
        this.maNguoiGiaoDich = maNguoiGiaoDich;
    }

    public float getResult(){
        return result;
    }
    @Override
    public void execute() {
        result = giaoDichDAO.calculateGiaoDich(maNguoiGiaoDich);
    }
}
