package org.example.domain.command;

import org.example.domain.model.GiaoDichDat;

public class AddGiaoDichDat implements Command {
    private GiaoDichDat giaoDichDat;

    public AddGiaoDichDat(GiaoDichDat giaoDichDat) {
        this.giaoDichDat = giaoDichDat;
    }

    @Override
    public void execute() {
        giaoDichDat.addGiaoDichDat(giaoDichDat);
    }
}
