Feature: The Rover and the control room at NASA maintain the same representation of the planet Mars in map form.

  @Mars.Map
  Scenario: Representing the Mars planet as a grid
    Given I set the mars rover on the 0, 0 position of the Mars grid
    And it is "north" oriented
    When I perform a "forward" move
    Then the position of the mars rover is 0, 1

  @Mars.Obstacle
  Scenario: On the Mars grid, it should be 4 obstacles distributed randomly
    Given I set the mars rover on the 0, 0 position of the Mars grid
    And it is "north" oriented
    When I perform a "forward" move
    Then the position of the mars rover is 0, 1

