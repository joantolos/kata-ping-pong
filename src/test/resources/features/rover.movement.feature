Feature: Basic movement of the Rover vehicle: Forward and backward when facing every possible direction.

  @Forward.North
  Scenario: Move the Rover forward when facing north
    Given I set the mars rover on the 0, 0 position of the Mars grid
    And it is "north" oriented
    When I perform a "forward" move
    Then the position of the mars rover is 0, 1

  @Backward.North
  Scenario: Move the Rover backward when facing north
    Given I set the mars rover on the 2, 2 position of the Mars grid
    And it is "north" oriented
    When I perform a "backward" move
    Then the position of the mars rover is 2, 1

  @Forward.South
  Scenario: Move the Rover forward when facing south
    Given I set the mars rover on the 9, 9 position of the Mars grid
    And it is "south" oriented
    When I perform a "forward" move
    Then the position of the mars rover is 9, 8

  @Backward.South
  Scenario: Move the Rover backward when facing south
    Given I set the mars rover on the 8, 8 position of the Mars grid
    And it is "south" oriented
    When I perform a "backward" move
    Then the position of the mars rover is 8, 9

  @Forward.East
  Scenario: Move the Rover forward when facing east
    Given I set the mars rover on the 0, 0 position of the Mars grid
    And it is "east" oriented
    When I perform a "forward" move
    Then the position of the mars rover is 1, 0

  @Backward.East
  Scenario: Move the Rover backward when facing west
    Given I set the mars rover on the 2, 2 position of the Mars grid
    And it is "east" oriented
    When I perform a "backward" move
    Then the position of the mars rover is 1, 2

  @Forward.West
  Scenario: Move the Rover forward when facing east
    Given I set the mars rover on the 2, 2 position of the Mars grid
    And it is "west" oriented
    When I perform a "forward" move
    Then the position of the mars rover is 1, 2

  @Backward.West
  Scenario: Move the Rover backward when facing west
    Given I set the mars rover on the 2, 2 position of the Mars grid
    And it is "west" oriented
    When I perform a "backward" move
    Then the position of the mars rover is 3, 2