Feature: To perform the CRUD Operations

  Scenario: To Perform the GET operation on Employees DB
    Given The Base URI is "http://localhost:3000/employees"
    When I perform the Get Operation
    Then Response Code should be 200