package org.example.domain.command.totalAmount;

import org.example.domain.command.Command;
import org.example.persistence.GiaoDichDAO;

public class AmountGiaoDichDat implements Command {
    private GiaoDichDAO giaoDichDAO;
    private int maNguoiGiaoDich, result;

    public AmountGiaoDichDat(GiaoDichDAO giaoDichDAO, int maNguoiGiaoDich) {
        this.giaoDichDAO = giaoDichDAO;
        this.maNguoiGiaoDich = maNguoiGiaoDich;
    }
    public int getResult(){
        return result;
    }
    @Override
    public void execute() {
        result = giaoDichDAO.amountGiaoDichDat(maNguoiGiaoDich);
    }
}
