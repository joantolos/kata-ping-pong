package com.joantolos.kata.mars.rover.ui

import com.joantolos.kata.mars.rover.domain.Position
import com.joantolos.kata.mars.rover.rover.Rover
import com.joantolos.kata.mars.rover.utils.Compass
import spock.lang.Specification

class RemoteControlSpec extends Specification {

    def 'Should send command stream to rover' (){

        given: 'A new rover'
        Rover rover = new Rover(0,0,Compass.NORTH)

        when: 'Sending the command "left, right, East, backwards'
        rover.getRemote().send('lrEb')

        then:
        rover.position == new Position(9, 0)
        rover.direction == Compass.EAST
    }

}
