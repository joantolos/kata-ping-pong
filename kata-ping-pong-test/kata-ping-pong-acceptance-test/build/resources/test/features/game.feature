Feature: Game

  @Ping
  Scenario: Checking if the service does ping
    Given I perform a "GET" to "http://localhost:7111/ping" end point
    Then the response at the json path "move" includes "Ping!"

  @Pong
  Scenario: Checking if the service does pong
    Given I perform a "GET" to "http://localhost:7111/pong" end point
    Then the response at the json path "move" includes "Pong!"

  @Play
  Scenario: Checking if the service does ping or pong when playing
    Given I perform a "GET" to "http://localhost:7111/play" end point
    Then the response at the json path "move" includes "Ping!" or "Pong!"