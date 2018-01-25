package com.joantolos.kata.mars.rover.domain

import spock.lang.Specification

class MarsSpec extends Specification {

    def 'Mars should have four random obstacles' () {
        expect:
        Mars.obstacles().size() == 4
    }
}
