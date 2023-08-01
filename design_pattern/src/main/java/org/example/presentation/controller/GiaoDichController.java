package org.example.presentation.controller;

import org.example.domain.command.AddGiaoDichDat;
import org.example.domain.command.Command;
import org.example.domain.model.GiaoDichDat;

public class GiaoDichController {
    private GiaoDichDat giaoDichDat;
    private Command addGiaoDichDatCommand;

    public GiaoDichController(GiaoDichDat giaoDichDat) {
        this.giaoDichDat = giaoDichDat;
        this.addGiaoDichDatCommand = new AddGiaoDichDat(giaoDichDat);
    }

    public void addGiaoDichDat(GiaoDichDat giaoDichDat) {
        addGiaoDichDatCommand.execute();
    }
}
