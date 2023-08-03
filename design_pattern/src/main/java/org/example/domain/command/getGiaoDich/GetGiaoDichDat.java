package org.example.domain.command.getGiaoDich;

import org.example.domain.command.Command;
import org.example.domain.model.GiaoDichDat;
import org.example.persistence.GiaoDichDAO;

import java.util.List;

public class GetGiaoDichDat implements Command {
    private GiaoDichDAO giaoDichDAO;
    private int maNguoiGiaoDich;
    private List<GiaoDichDat> giaoDichDatList;

    public GetGiaoDichDat(GiaoDichDAO giaoDichDAO, int maNguoiGiaoDich) {
        this.giaoDichDAO = giaoDichDAO;
        this.maNguoiGiaoDich = maNguoiGiaoDich;
    }

    @Override
    public void execute() {
        giaoDichDatList = giaoDichDAO.getGiaoDichDatByUserId(maNguoiGiaoDich);
    }

    public List<GiaoDichDat> getGiaoDichDatList() {
        return giaoDichDatList;
    }
}
