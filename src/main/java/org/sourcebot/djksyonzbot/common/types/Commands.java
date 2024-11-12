package org.sourcebot.djksyonzbot.common.types;

import lombok.Getter;

@Getter
public enum Commands {
    PLAY("!play");

    private final String command;

    Commands(String command) {
        this.command = command;
    }


    @Override
    public String toString() {
        return "Commands{" +
                "command='" + command + '\'' +
                '}';
    }
}
