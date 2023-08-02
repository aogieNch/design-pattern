package org.example.domain.command.getGiaoDich;

import org.example.domain.command.Command;
import org.example.domain.model.GiaoDichDat;
import org.example.persistence.GiaoDichDAO;

import java.util.List;

public class GetGiaoDichDat implements Command {
    private GiaoDichDAO giaoDichDAO;
    private int maNguoiGiaoDich;

    public GetGiaoDichDat(GiaoDichDAO giaoDichDAO, int maNguoiGiaoDich) {
        this.giaoDichDAO = giaoDichDAO;
        this.maNguoiGiaoDich = maNguoiGiaoDich;
    }

    @Override
    public void execute() {
        List<GiaoDichDat> giaoDichDatList = giaoDichDAO.getGiaoDichDatByUserId(maNguoiGiaoDich);
    }
}
