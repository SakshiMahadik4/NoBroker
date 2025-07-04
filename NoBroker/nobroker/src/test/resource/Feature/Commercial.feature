Feature: Commercial Section Functionality on NoBroker Homepage
 
  As a user visiting the NoBroker website,
  I want to access and interact with the Commercial section on the homepage,
  So that I can explore commercial property options efficiently.
 
 
Scenario: Validate navigation to the commercial properties section
    Given the user is on the NoBroker website homepage
    When the user clicks on the "Commercial" tab
    Then the user should be navigated to the commercial properties section

 
  Scenario: Validate Commercial properties are listed correctly
    Given I am on the Commercial section page
    When I scroll through the listings
    Then I should see commercial properties with location, price, and property type displayed
 
Scenario: Validate updating search results with property type filter
    Given the user is on the commercial properties section
    When the user selects a property type filter
    Then the search results should update to display only properties of the selected type
 
  
Scenario: Validate updating search results with property type filter
    Given the user is on the commercial properties section
    When the user selects a property type filter
    Then the search results should update to display only properties of the selected type

Scenario: Validate initiating contact or scheduling a visit
    Given the user is on the commercial properties section
    When the user clicks on the contact options or "Schedule Visit" button
    Then the user should be able to initiate contact or schedule a visit

Scenario: Validate handling of invalid or non-existent location
    Given the user is on the NoBroker website homepage
    When the user enters an invalid or non-existent location and performs a search
    Then an appropriate error message should be displayed
