package com.joantolos.kata.mars.rover.acceptance;

import com.joantolos.kata.mars.rover.domain.Movements;
import com.joantolos.kata.mars.rover.domain.Rover;
import com.joantolos.kata.mars.rover.ui.Console;
import com.joantolos.kata.mars.rover.tools.Compass;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.io.IOException;

public class RoverSteps {

    private Rover rover;

    @Given("^I set the mars rover on the (\\d+), (\\d+) position of the Mars grid$")
    public void iSetTheMarsRoverOnThePositionOfTheMarsGrid(int x, int y) throws IOException {
        this.rover = new Rover(x, y, Compass.NORTH, new Console());
    }

    @And("^it is \"([^\"]*)\" oriented$")
    public void itIsOriented(String orientation) {
        this.rover.sendSequence(Movements.getCommand(orientation));
    }

    @When("^I perform a \"([^\"]*)\" move$")
    public void iPerformAMove(String move) {
        this.rover.sendSequence(Movements.getCommand(move));
    }

    @Then("^the position of the mars rover is (\\d+), (\\d+)$")
    public void thePositionOfTheMarsRoverIs(Integer expectedX, Integer expectedY) {
        Assert.assertEquals(expectedX, this.rover.getPosition().getX());
        Assert.assertEquals(expectedY, this.rover.getPosition().getY());
    }

    @When("^I send the command sequence \"([^\"]*)\"$")
    public void iSendTheCommandSequence(String sequence) {
        this.rover.sendSequence(sequence);
    }
}
