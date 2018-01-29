package com.joantolos.kata.mars.rover.rover

import com.joantolos.kata.mars.rover.domain.Mars
import com.joantolos.kata.mars.rover.domain.Position
import com.joantolos.kata.mars.rover.ui.Console
import com.joantolos.kata.mars.rover.utils.Compass
import spock.lang.Specification

class RoverSpec extends Specification {

    def 'Mars Rover should return its location' () {
        given:
        Rover rover = new Rover(0,0,Compass.NORTH, new Console())

        expect:
        rover.getPosition()
    }

    def 'Mars Rover should move forwards when facing every direction, including edge positions' () {

        given: 'Moving a new rover forwards'
        Rover rover = new Rover(startingX, startingY, direction, new Console())
        rover.move(Movements.FORWARD)

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

    def 'Mars Rover should move backwards when facing every direction, including edge positions' () {

        given: 'Moving a new rover backwards'
        Rover rover = new Rover(startingX, startingY, direction, new Console())
        rover.move(Movements.BACKWARD)

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
        Rover rover = new Rover(startingX, startingY, direction, new Console())
        rover.move(Movements.LEFT)

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
        Rover rover = new Rover(startingX, startingY, direction, new Console())
        rover.move(Movements.RIGHT)

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

    def 'Should send command stream to rover' () {

        given: 'A new rover'
        Rover rover = new Rover(0,0,Compass.NORTH, new Console())

        when: 'Sending the command "left, right, East, backwards, North, forwards, South, West"'
        rover.sendSequence('lrEbNfSW')

        then:
        rover.position == new Position(1, 9)
        rover.direction == Compass.WEST
    }

    def 'Should stop the rover when found an obstacle' () {

        given: 'A new rover'
        Rover rover = new Rover(0,0,Compass.NORTH, new Console())

        when: 'Moving the rover to all possible positions'
        Integer numberOfMovementsMade = 0

        for(int i=1; i<= Mars.SIZE; i++){
            for(int j=1; j<= Mars.SIZE; j++){
                if(!rover.sendSequence('r'))
                    break
                numberOfMovementsMade++
            }
            if(!rover.sendSequence('f'))
                break
        }

        then: 'The number of movements should be less than the total square number'
        Integer maximumSquaresPossible = Mars.SIZE * Mars.SIZE
        numberOfMovementsMade < maximumSquaresPossible
    }
}
