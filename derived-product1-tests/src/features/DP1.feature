Feature: Checking core product flows

  Background: User Navigates to Home Page
    Given We go to DP1 home page
    When I try to accept cookies
    Then Cookie popup should not be visible

  Scenario: Check whether we are able to generate Jacket Details or not
    Given We are logged into DP1 home page
    Then We should be able to get count of slides
    And We should be able to get titles of each slide
    And We should be able to verify time taken by each slide
