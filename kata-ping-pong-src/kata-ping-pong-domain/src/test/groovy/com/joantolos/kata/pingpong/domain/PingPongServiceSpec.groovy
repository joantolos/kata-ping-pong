package com.joantolos.kata.pingpong.domain

import spock.lang.Shared
import spock.lang.Specification

class PingPongServiceSpec extends Specification {

    @Shared PingPongService pingPongService

    def setupSpec() {
        pingPongService = new PingPongService()
    }

    def 'Should respond ping at least once when playing' () {
        expect:
        while ({
            pingPongService.play().move != 'Ping!'
        }());
    }

    def 'Should respond pong at least once when playing' () {
        expect:
        while ({
            pingPongService.play().move != 'Pong!'
        }());
    }
}
