package org.example.domain.command;

import org.example.domain.model.GiaoDichDat;
import org.example.domain.model.service.GiaoDichDatService;

public class AddGiaoDichDat extends Command {
    private GiaoDichDatService giaoDichDatService;
    private GiaoDichDat giaoDichDat;

    public AddGiaoDichDat(GiaoDichDatService giaoDichDatService, GiaoDichDat giaoDichDat) {
        this.giaoDichDatService = giaoDichDatService;
        this.giaoDichDat = giaoDichDat;
    }
    @Override
    public void execute() {
        giaoDichDatService.addGiaoDichDat(giaoDichDat);
    }
}
