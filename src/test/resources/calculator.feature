Feature: Calculator
  Scenario Outline: Addition with different values
    Given I have a calculator
    When I add <a> and <b>
    Then the result should be <expected>

    Examples:
      | a | b | expected |
      | 3 | 5 | 8        |
      | 2 | 3 | 5        |
      | 0 | 0 | 0        |
      | -1| 1 | 0        |
