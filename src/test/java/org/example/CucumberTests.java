package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class CucumberTests {

    private int first;
    private int second;
    private int res;

    @Given("Entered {int} as the 1st number")
    public void setFirst(int number) {
        this.first = number;
    }

    @Given("Entered {int} as the 2nd number")
    public void setSecond(int number) {
        this.second = number;
    }

    @When("Divide")
    public void divide() {
        res = first / second;
    }

    @Then("Result is {int}")
    public void getResult(int expectedResult) {
        assertEquals(expectedResult, res);
    }
}
