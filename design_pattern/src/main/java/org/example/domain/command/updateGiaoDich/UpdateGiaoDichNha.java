package org.example.domain.command.updateGiaoDich;

import org.example.domain.command.Command;
import org.example.domain.model.GiaoDichNha;
import org.example.persistence.GiaoDichDAO;

public class UpdateGiaoDichNha implements Command {
    private final GiaoDichDAO giaoDichDAO;
    private final GiaoDichNha giaoDichNha;

    public UpdateGiaoDichNha(GiaoDichDAO giaoDichDAO, GiaoDichNha giaoDichNha) {
        this.giaoDichDAO = giaoDichDAO;
        this.giaoDichNha = giaoDichNha;
    }

    @Override
    public void execute() {
        giaoDichDAO.updateGiaoDichNha(giaoDichNha);
    }
}
