package com.joantolos.kata.mars.rover.rover;

import com.joantolos.kata.mars.rover.ui.Console;

public class RemoteControl {

    private Rover rover;
    private Console console;

    RemoteControl(Rover rover){
        this.rover = rover;
        this.console = new Console();
    }

    public void send(String commandStream) {
        commandStream.chars().forEach(command -> rover.move(Movements.byCommand(""+(char) command)));
    }
}
