Feature: To perform the CRUD Operations

  Background: Start the json-db-server
    Given The Base URI is "http://localhost:3000/employees"

  @Sanity
  Scenario: To Perform the GET operation on Employees DB
    When I perform the Get Operation
    Then GET Response Code should be 200

  @Sanity
  Scenario: To Perform the POST operation on Employees DB
    When I perform the POST Operation
    Then POST Response Code should be 201

  @Sanity
  Scenario: To Perform the PUT operation on Employees DB
    When I perform the PUT Operation
    Then PUT Response Code should be 200

  @Sanity
  Scenario: To Perform the DELETE operation on Employees DB
    When I perform the DELETE Operation
    Then DELETE Response Code should be 200
