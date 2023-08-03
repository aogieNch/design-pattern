package org.example.domain.command.updateGiaoDich;

import org.example.domain.command.Command;
import org.example.domain.model.GiaoDichDat;
import org.example.persistence.GiaoDichDAO;

public class UpdateGiaoDichDat implements Command {
    private final GiaoDichDAO giaoDichDAO;
    private final GiaoDichDat giaoDichDat;

    public UpdateGiaoDichDat(GiaoDichDAO giaoDichDAO, GiaoDichDat giaoDichDat) {
        this.giaoDichDAO = giaoDichDAO;
        this.giaoDichDat = giaoDichDat;
    }

    @Override
    public void execute() {
        giaoDichDAO.updateGiaoDichDat(giaoDichDat);
    }
}
