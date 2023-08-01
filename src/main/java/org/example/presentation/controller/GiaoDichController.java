package org.example.presentation.controller;

import org.example.domain.command.AddGiaoDichDat;
import org.example.domain.command.CommandProcessor;
import org.example.domain.model.GiaoDichDat;
import org.example.domain.model.service.GiaoDichDatService;

public class GiaoDichController {

    private GiaoDichDatService giaoDichDatService;

    public GiaoDichController() {

    }

    public void addGiaoDichDat(GiaoDichDat giaoDichDat) {
        AddGiaoDichDat command = new AddGiaoDichDat(giaoDichDatService, giaoDichDat);
        CommandProcessor commandProcessor = new CommandProcessor();
        commandProcessor.execute(command);
    }
}
