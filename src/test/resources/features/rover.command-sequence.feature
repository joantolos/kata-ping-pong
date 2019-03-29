Feature: The Rover vehicle is able to process a sequence of commands.

  @Command.Sequence
  Scenario: The Rover vehicle accepts a command sequence.
    Given I set the mars rover on the 0, 0 position of the Mars grid
    And it is "north" oriented
    When I send the command sequence "ffef"
    Then the position of the mars rover is 1, 2