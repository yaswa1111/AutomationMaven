Feature: Checking core product flows

  Background: User Navigates to Home Page
    Given We go to DP2 home page
    When I try to accept cookies
    Then Cookie popup should not be visible

  Scenario: Check whether we are able to generate Jacket Details or not
    Given We are logged into DP2 home page
    When We scroll down to bottom of page
    Then We should be able to see multiple links
    And We should be able to write hyperlinks to CSV
    And We can print duplicate hyperlinks
