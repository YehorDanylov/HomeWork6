package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.jupiter.api.Assertions.*;

public class CucumberTest {
    private App calculator;
    private int result;

    @Given("I have a calculator")
    public void i_have_a_calculator() {
        calculator = new App();
    }

    @When("I add {int} and {int}")
    public void i_add(int a, int b) {
        result = calculator.add(a, b);
    }

    @Then("the result should be {int}")
    public void the_result_should_be(int expected) {
        assertEquals(expected, result);
    }
}
