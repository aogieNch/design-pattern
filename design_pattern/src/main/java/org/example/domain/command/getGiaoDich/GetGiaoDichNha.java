package org.example.domain.command.getGiaoDich;

import org.example.domain.command.Command;
import org.example.domain.model.GiaoDichNha;
import org.example.persistence.GiaoDichDAO;

import java.util.List;

public class GetGiaoDichNha implements Command {
    private final GiaoDichDAO giaoDichDAO;
    private final int maNguoiGiaoDich;
    private List<GiaoDichNha> giaoDichNhaList;
    public GetGiaoDichNha(GiaoDichDAO giaoDichDAO, int maNguoiGiaoDich) {
        this.giaoDichDAO = giaoDichDAO;
        this.maNguoiGiaoDich = maNguoiGiaoDich;
    }

    @Override
    public void execute() {
        giaoDichNhaList = giaoDichDAO.getGiaoDichNhaByUserId(maNguoiGiaoDich);
    }

    public List<GiaoDichNha> getGiaoDichNhaList() {
        return giaoDichNhaList;
    }
}
