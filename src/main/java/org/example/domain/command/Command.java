package org.example.domain.command;

import org.example.domain.model.service.GiaoDichDatService;

public abstract class Command {
    protected GiaoDichDatService giaoDichDatService;

    public abstract void execute();

    public Command(){}
    public Command(GiaoDichDatService giaoDichDatService) {
        this.giaoDichDatService = giaoDichDatService;
    }
}
