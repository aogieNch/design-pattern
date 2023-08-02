package org.example.domain.command.addGiaoDich;

import org.example.domain.command.Command;
import org.example.domain.model.GiaoDichDat;
import org.example.persistence.GiaoDichDAO;

public class AddGiaoDichDat implements Command {
    private final GiaoDichDAO giaoDichDAO;
    private final GiaoDichDat giaoDichDat;

    public AddGiaoDichDat(GiaoDichDAO giaoDichDAO, GiaoDichDat giaoDichDat) {
        this.giaoDichDAO = giaoDichDAO;
        this.giaoDichDat = giaoDichDat;
    }

    @Override
    public void execute() {
        giaoDichDAO.addGiaoDichDat(giaoDichDat);
    }
}
