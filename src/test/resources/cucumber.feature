Feature: Divide

  Scenario Outline: Addition of two numbers
    Given Entered <first> as the 1st number
    And Entered <second> as the 2nd number
    When Divide
    Then Result is <result>

    Examples:
      | first | second | result |
      | 15    | 5      | 3      |
      | 2     | 1      | 2      |
      | 0     | 2      | 0      |
