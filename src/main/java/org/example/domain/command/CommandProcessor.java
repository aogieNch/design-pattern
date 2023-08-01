package org.example.domain.command;

public class CommandProcessor {
    public void execute(Command command) {
        command.execute();
    }
}
