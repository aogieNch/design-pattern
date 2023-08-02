package org.example.presentation.controller;

import org.example.domain.command.AddGiaoDichDat;
import org.example.domain.command.Command;
import org.example.domain.model.GiaoDichDat;
import org.example.domain.model.service.GiaoDichService;

public class GiaoDichController {
    private GiaoDichService giaoDichService;
    private GiaoDichDat giaoDichDat;

    public GiaoDichController(GiaoDichService giaoDichService) {
        this.giaoDichService = giaoDichService;
    }

    public void addGiaoDichDat(GiaoDichDat giaoDichDat) {
        giaoDichService.addGiaoDichDat(giaoDichDat);
    }
}
