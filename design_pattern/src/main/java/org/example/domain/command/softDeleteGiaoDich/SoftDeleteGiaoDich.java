package org.example.domain.command.softDeleteGiaoDich;

import org.example.domain.command.Command;
import org.example.persistence.GiaoDichDAO;

public class SoftDeleteGiaoDich implements Command {

    private final GiaoDichDAO giaoDichDAO;
    private final int maGiaoDich;
    private final int maNguoiGiaoDich;

    public SoftDeleteGiaoDich(GiaoDichDAO giaoDichDAO, int maGiaoDich, int maNguoiGiaoDich) {
        this.giaoDichDAO = giaoDichDAO;
        this.maGiaoDich = maGiaoDich;
        this.maNguoiGiaoDich = maNguoiGiaoDich;
    }

    @Override
    public void execute() {
        giaoDichDAO.softDeleteGiaoDich(maGiaoDich, maNguoiGiaoDich);
    }
}
