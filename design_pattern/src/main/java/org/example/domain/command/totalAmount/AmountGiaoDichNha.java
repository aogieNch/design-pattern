package org.example.domain.command.totalAmount;

import org.example.domain.command.Command;
import org.example.persistence.GiaoDichDAO;

public class AmountGiaoDichNha implements Command {
    private final GiaoDichDAO giaoDichDAO;
    private final int maNguoiGiaoDich;
    private int result;

    public AmountGiaoDichNha(GiaoDichDAO giaoDichDAO, int maNguoiGiaoDich) {
        this.giaoDichDAO = giaoDichDAO;
        this.maNguoiGiaoDich = maNguoiGiaoDich;
    }
    public int getResult(){
        return result;
    }
    @Override
    public void execute() {
        result = giaoDichDAO.amountGiaoDichNha(maNguoiGiaoDich);
    }
}
