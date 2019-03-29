package com.joantolos.kata.mars.rover.ui

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

}
