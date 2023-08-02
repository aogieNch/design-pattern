package org.example.domain.command.calculateGiaoDich;

import org.example.domain.command.Command;
import org.example.persistence.GiaoDichDAO;

public class CalculateAvgGiaoDichNha implements Command {
    private final GiaoDichDAO giaoDichDAO;
    private final int maNguoiGiaoDich;
    private float result;

    public CalculateAvgGiaoDichNha(GiaoDichDAO giaoDichDAO, int maNguoiGiaoDich) {
        this.giaoDichDAO = giaoDichDAO;
        this.maNguoiGiaoDich = maNguoiGiaoDich;
    }

    public float getResult(){
        return result;
    }
    @Override
    public void execute() {
        result = giaoDichDAO.calculateGiaoDichNha(maNguoiGiaoDich);
    }
}
