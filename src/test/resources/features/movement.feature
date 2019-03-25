Feature: Basic movement of the Rover vehicle: Forward and backward when facing every possible direction.

  @Forwards.North
  Scenario: Move the Rover forwards when facing north
    Given I set the mars rover on the 0, 0 position of the Mars grid
    And it is "north" oriented
    When I perform a "forward" move
    Then the position of the mars rover is 0, 1

  @Backwards.North
  Scenario: Move the Rover backward when facing north
    Given I set the mars rover on the 2, 2 position of the Mars grid
    And it is "north" oriented
    When I perform a "backward" move
    Then the position of the mars rover is 2, 1