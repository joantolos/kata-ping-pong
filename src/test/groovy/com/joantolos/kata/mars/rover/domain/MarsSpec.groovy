package com.joantolos.kata.mars.rover.domain

import spock.lang.Shared
import spock.lang.Specification

class MarsSpec extends Specification {

    @Shared Mars mars

    def setupSpec() {
        mars = new Mars()
    }

    def 'Mars should have four random obstacles' () {
        expect:
        mars.obstacles().size() == 1
    }
}
