package org.example.domain.command;

import org.example.domain.model.GiaoDichDat;
import org.example.persistence.GiaoDichDAO;

public class AddGiaoDichDat implements Command {
    private GiaoDichDAO giaoDichDAO;
    private GiaoDichDat giaoDichDat;

    public AddGiaoDichDat(GiaoDichDAO giaoDichDAO, GiaoDichDat giaoDichDat) {
        this.giaoDichDAO = giaoDichDAO;
        this.giaoDichDat = giaoDichDat;
    }

    @Override
    public void execute() {
        giaoDichDAO.addGiaoDichDat(giaoDichDat);
    }
}
