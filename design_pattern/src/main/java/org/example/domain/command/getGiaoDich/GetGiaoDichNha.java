package org.example.domain.command.getGiaoDich;

import org.example.domain.command.Command;
import org.example.domain.model.GiaoDichNha;
import org.example.persistence.GiaoDichDAO;

import java.util.List;

public class GetGiaoDichNha implements Command {
    private final GiaoDichDAO giaoDichDAO;
    private int maNguoiGiaoDich;

    public GetGiaoDichNha(GiaoDichDAO giaoDichDAO, int maNguoiGiaoDich) {
        this.giaoDichDAO = giaoDichDAO;
        this.maNguoiGiaoDich = maNguoiGiaoDich;
    }

    @Override
    public void execute() {
        List<GiaoDichNha> giaoDichDatList = giaoDichDAO.getGiaoDichNhaByUserId(maNguoiGiaoDich);
    }
}
