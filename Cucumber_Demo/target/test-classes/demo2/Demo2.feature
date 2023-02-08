#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: DemoApp

  @tag1
  Scenario Outline: Checking Functionality of Login module
    Given User must be on Login page by clicking on url "https://demo.applitools.com/"
    When Enter <username> and <password>
    And Click in button
    Then ACME home page should be displayed
    Examples:
      | username | password    |
      | Amu      | Amu123      |
      | Bachu    | Bachu123    |
      | Chimpal  | Chimapal123 |
