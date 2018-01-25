package com.joantolos.kata.mars.rover.rover

import com.joantolos.kata.mars.rover.utils.Compass
import spock.lang.Shared
import spock.lang.Specification

class RoverSpec extends Specification {

    @Shared Rover rover

    def setupSpec() {
        rover = new Rover(0,0,Compass.NORTH)
    }

    def 'Mars Rover should return its location' () {
        expect:
        rover.getPosition()
    }

    def 'Mars Rover should move forward' () {
        expect:
        rover.moveForward(Compass.NORTH)
    }

    def 'Mars Rover should move backward' () {
        expect:
        rover.moveBackward()
    }

    def 'Mars Rover should move left' () {
        expect:
        rover.moveLeft()
    }

    def 'Mars Rover should move right' () {
        expect:
        rover.moveRight()
    }
}
