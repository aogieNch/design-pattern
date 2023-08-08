package org.example.domain.command.addGiaoDich;

import org.example.domain.command.Command;
import org.example.domain.model.GiaoDichNha;
import org.example.persistence.GiaoDichDAO;

public class AddGiaoDichNha implements Command {
    private final GiaoDichDAO giaoDichDAO;
    private final GiaoDichNha giaoDichNha;

    public AddGiaoDichNha(GiaoDichDAO giaoDichDAO, GiaoDichNha giaoDichNha) {
        this.giaoDichDAO = giaoDichDAO;
        this.giaoDichNha = giaoDichNha;
    }

    @Override
    public void execute() {
        giaoDichDAO.addGiaoDichNha(giaoDichNha);
    }}
