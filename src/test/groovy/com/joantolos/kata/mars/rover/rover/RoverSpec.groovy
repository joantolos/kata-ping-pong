package com.joantolos.kata.mars.rover.rover

import com.joantolos.kata.mars.rover.utils.Compass
import spock.lang.Specification

class RoverSpec extends Specification {

    def 'Mars Rover should return its location' () {
        given:
        Rover rover = new Rover(0,0,Compass.NORTH)

        expect:
        rover.getPosition()
    }

    def 'Mars Rover should move forward when facing every direction, including edge positions' () {

        given: 'Moving a new rover forward'
        Rover rover = new Rover(startingX, startingY, direction)
        rover.moveForward()

        expect: 'The correct position'
        rover.getPosition().x == expectingX
        rover.getPosition().y == expectingY

        where: 'The rover is facing all possible directions'
        startingX   |   startingY   ||   direction          |   expectingX  |   expectingY
        1           |   1           ||   Compass.NORTH      |   1           |   2
        1           |   1           ||   Compass.SOUTH      |   1           |   0
        1           |   1           ||   Compass.EAST       |   2           |   1
        1           |   1           ||   Compass.WEST       |   0           |   1

        9           |   9           ||   Compass.NORTH      |   9           |   0
        0           |   0           ||   Compass.SOUTH      |   0           |   9
        9           |   9           ||   Compass.EAST       |   0           |   9
        0           |   0           ||   Compass.WEST       |   9           |   0
    }

    def 'Mars Rover should move backward when facing every direction, including edge positions' () {

        given: 'Moving a new rover forward'
        Rover rover = new Rover(startingX, startingY, direction)
        rover.moveBackward()

        expect: 'The correct position'
        rover.getPosition().x == expectingX
        rover.getPosition().y == expectingY

        where: 'The rover is facing all possible directions'
        startingX   |   startingY   ||   direction          |   expectingX  |   expectingY
        1           |   1           ||   Compass.NORTH      |   1           |   0
        1           |   1           ||   Compass.SOUTH      |   1           |   2
        1           |   1           ||   Compass.EAST       |   0           |   1
        1           |   1           ||   Compass.WEST       |   2           |   1

        9           |   9           ||   Compass.SOUTH      |   9           |   0
        0           |   0           ||   Compass.NORTH      |   0           |   9
        9           |   9           ||   Compass.WEST       |   0           |   9
        0           |   0           ||   Compass.EAST       |   9           |   0
    }

    def 'Mars Rover should move left' () {

        given: 'Moving a new rover left'
        Rover rover = new Rover(startingX, startingY, direction)
        rover.moveLeft()

        expect: 'The correct position'
        rover.getPosition().x == expectingX
        rover.getPosition().y == expectingY

        where: 'The rover is facing all possible directions'
        startingX   |   startingY   ||   direction          |   expectingX  |   expectingY
        1           |   1           ||   Compass.NORTH      |   0           |   1
        1           |   1           ||   Compass.SOUTH      |   0           |   1
        1           |   1           ||   Compass.EAST       |   2           |   1
        1           |   1           ||   Compass.WEST       |   2           |   1

        0           |   0           ||   Compass.SOUTH      |   9           |   0
        0           |   0           ||   Compass.NORTH      |   9           |   0
        9           |   9           ||   Compass.EAST       |   0           |   9
        9           |   9           ||   Compass.WEST       |   0           |   9
    }

    def 'Mars Rover should move right' () {

        given: 'Moving a new rover right'
        Rover rover = new Rover(startingX, startingY, direction)
        rover.moveRight()

        expect: 'The correct position'
        rover.getPosition().x == expectingX
        rover.getPosition().y == expectingY

        where: 'The rover is facing all possible directions'
        startingX   |   startingY   ||   direction          |   expectingX  |   expectingY
        1           |   1           ||   Compass.NORTH      |   2           |   1
        1           |   1           ||   Compass.SOUTH      |   2           |   1
        1           |   1           ||   Compass.EAST       |   0           |   1
        1           |   1           ||   Compass.WEST       |   0           |   1

        9           |   9           ||   Compass.SOUTH      |   0           |   9
        9           |   9           ||   Compass.NORTH      |   0           |   9
        0           |   0           ||   Compass.EAST       |   9           |   0
        0           |   0           ||   Compass.WEST       |   9           |   0
    }
}
