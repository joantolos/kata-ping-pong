package com.joantolos.kata.mars.rover.rover

import com.joantolos.kata.mars.rover.domain.Position
import com.joantolos.kata.mars.rover.utils.Compass
import spock.lang.Shared
import spock.lang.Specification

class MarsMapSpec extends Specification {

//    @Shared MarsMap marsMap
//
//    def setupSpec() {
//        marsMap = new MarsMap(new Position(0,0), Compass.NORTH)
//    }
//
//    def 'Mars map should return initial coordinates state' () {
//        expect:
//        marsMap.getCoordinates()[0][0] == '[ ↑ ]'
//    }
//
//    def 'Mars map should return new position' () {
//        given: 'I mark the new Mars rover position'
//        marsMap.render(new Position(0, 1), Compass.EAST)
//
//        expect:
//        marsMap.getCoordinates()[0][0] == '[   ]'
//        marsMap.getCoordinates()[1][0] == '[ → ]'
//    }

    def 'Mars map should return initial position' () {
        given: 'I mark the new Mars rover position'
        new MarsMap(new Position(0,0), Compass.NORTH)
    }
}
