package org.example.domain.command.serchGiaoDich;

import org.example.domain.command.Command;
import org.example.domain.model.GiaoDich;
import org.example.persistence.GiaoDichDAO;

public class GetGiaoDichByMaGiaoDich implements Command {
    private final GiaoDichDAO giaoDichDAO;
    private final int maGiaoDich;
    private final int maNguoiGiaoDich;

    private GiaoDich giaoDich;

    public GetGiaoDichByMaGiaoDich(GiaoDichDAO giaoDichDAO, int maGiaoDich, int maNguoiGiaoDich) {
        this.giaoDichDAO = giaoDichDAO;
        this.maGiaoDich = maGiaoDich;
        this.maNguoiGiaoDich = maNguoiGiaoDich;
    }

    public GiaoDich getGiaoDich() {
        return giaoDich;
    }

    @Override
    public void execute() {
        giaoDich = giaoDichDAO.getGiaoDichByMaGiaoDich(maGiaoDich, maNguoiGiaoDich);
    }
}
