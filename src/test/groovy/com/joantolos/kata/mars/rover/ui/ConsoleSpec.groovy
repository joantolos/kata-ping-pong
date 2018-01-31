package com.joantolos.kata.mars.rover.ui

import com.joantolos.kata.mars.rover.rover.Rover
import com.joantolos.kata.mars.rover.utils.Compass
import spock.lang.Specification

class ConsoleSpec extends Specification {

    Console ui

    def setup() {
        ui = new Console()
    }

    def 'User Interface should print prompt'(){
        expect:
        ui.prompt()
    }

    def 'User Interface should print exit'(){
        expect:
        ui.exit()
    }

    def 'User Interface should print random text'(){
        expect:
        ui.print("Random text")
    }

    def 'User Interface should print the mars map'(){
        given: 'A new rover'
        Rover rover = new Rover(3,5, Compass.NORTH, new Console())

        expect:
        ui.printMap(rover)
    }
}
