Feature: Checking core product flows

  Background: User Navigates to Home Page
    Given We go to CP home page
    When I try to close modal
    And I try to accept cookies
    Then Popup should be closed

  @Shop
  Scenario: Check whether we are able to generate Jacket Details or not
    Given We are logged into CP home page
    When I hover on Shop
    And I click on Men's
    Then details should be opened in new tab
    Given We are logged into CP shop page
    When We click on Jackets
    Then We should be able to see all Jackets

  @News
  Scenario: Check whether we are able to view news count or not
    Given We are logged into CP home page
    When I hover on Menu
    And I click on News
    Given We are navigated to CP News page
    Then We should be able to see all Videos